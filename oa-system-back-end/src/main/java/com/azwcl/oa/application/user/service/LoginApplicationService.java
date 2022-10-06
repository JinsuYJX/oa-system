package com.azwcl.oa.application.user.service;

import com.azwcl.oa.application.user.converter.ToImageVerificationCodeVoConverter;
import com.azwcl.oa.application.user.converter.ToPersonAuthConverter;
import com.azwcl.oa.application.user.converter.ToPersonInfoVoConverter;
import com.azwcl.oa.domain.code.model.entity.ImageVerificationCodeDO;
import com.azwcl.oa.domain.code.model.enums.CodeType;
import com.azwcl.oa.domain.code.service.ImageVerificationCodeService;
import com.azwcl.oa.domain.person.model.enums.LoginTypeEnum;
import com.azwcl.oa.domain.person.model.enums.PersonAuthType;
import com.azwcl.oa.domain.person.repo.po.PersonAuth;
import com.azwcl.oa.domain.person.repo.po.PersonInfo;
import com.azwcl.oa.domain.person.repo.po.PersonToken;
import com.azwcl.oa.domain.person.service.PersonAuthService;
import com.azwcl.oa.domain.person.service.PersonInfoService;
import com.azwcl.oa.infrastructure.exception.AssertionException;
import com.azwcl.oa.infrastructure.utils.MessageSourceUtil;
import com.azwcl.oa.infrastructure.utils.StringUtil;
import com.azwcl.oa.interfaces.user.command.LoginCommand;
import com.azwcl.oa.interfaces.user.vo.ImageVerificationCodeVO;
import com.azwcl.oa.interfaces.user.vo.PersonInfoVO;
import com.azwcl.oa.interfaces.user.vo.UserDetailsVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * login application service
 *
 * @author az
 * @date 2022/09/29
 */

@Service
@RequiredArgsConstructor
public class LoginApplicationService {

    private final ImageVerificationCodeService imageVerificationCodeService;

    private final MessageSourceUtil messageSourceUtil;

    private final PersonAuthService personAuthService;

    private final PersonInfoService personInfoService;

    /**
     * 获取登录图片验证码
     *
     * @return 登录图片验证码
     */
    public ImageVerificationCodeVO getLoginImageVerificationCode() {
        ImageVerificationCodeDO imageVerificationCodeDo = imageVerificationCodeService.getImageVerificationCodeDo(CodeType.LOGIN);
        return ToImageVerificationCodeVoConverter.CONVERTER.toImageVerificationCodeVo(imageVerificationCodeDo);
    }

    public UserDetailsVO loginByPassword(LoginCommand command) {
        command.setPassword(StringUtil.md5(command.getPassword()));

        // 验证图片验证码是否正确
        ImageVerificationCodeDO inputCodeDo = new ImageVerificationCodeDO(command.getUid(), command.getCode(), CodeType.LOGIN);
        if(!imageVerificationCodeService.isValid(inputCodeDo)) {
            throw new AssertionException(100003, messageSourceUtil.getMessage("100003"));
        }

        // 验证账号密码是否正确
        PersonAuth inputAuth = ToPersonAuthConverter.CONVERTER.toPersonAuth(command, PersonAuthType.EMAIL_PASSWORD.getType());

        PersonAuth authentication = personAuthService.getPersonAuthentication(inputAuth);
        if (Objects.isNull(authentication)) {
            throw new AssertionException(100000, messageSourceUtil.getMessage("100000"));
        }

        if(!authentication.equals(inputAuth)) {
            throw new AssertionException(100004, messageSourceUtil.getMessage("100004"));
        }

        // 获取用户信息返回
        PersonInfo info = personInfoService.getPersonInfo(authentication.getPersonId());
        PersonInfoVO infoVO = ToPersonInfoVoConverter.CONVERTER.toPersonInfoVo(info);

        // 加载该角色进入缓存
        personInfoService.loadUserRoles(infoVO.getId());

        // 存储用户 token 信息
        PersonToken token = personInfoService.generatePersonToken(info.getId(), LoginTypeEnum.WEB);

        return new UserDetailsVO(token.getToken(), infoVO);
    }

}
