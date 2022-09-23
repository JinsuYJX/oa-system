package com.azwcl.oa.application.user.service;

import com.azwcl.oa.application.user.converter.ToImageVerificationCodeVoConverter;
import com.azwcl.oa.domain.code.entity.domainobject.ImageVerificationCodeDO;
import com.azwcl.oa.domain.code.entity.domainobject.MessageVerificationCodeDO;
import com.azwcl.oa.domain.code.entity.enums.VerificationCodeModel;
import com.azwcl.oa.domain.code.service.VerificationCodeService;
import com.azwcl.oa.infrastructure.common.enums.HttpStatus;
import com.azwcl.oa.infrastructure.common.exception.AssertionException;
import com.azwcl.oa.infrastructure.utils.MessageSourceUtil;
import com.azwcl.oa.interfaces.user.dto.VerificationCodeDTO;
import com.azwcl.oa.interfaces.user.vo.ImageVerificationCodeVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 用户登录 application service
 *
 * @author az
 * @date 2022/09/20
 */

@Service
@RequiredArgsConstructor
public class UserLoginApplicationService {
    private final VerificationCodeService verificationCodeService;

    private final MessageSourceUtil messageSourceUtil;

    /**
     * 获取登录图片验证码
     *
     * @return 图片验证码
     */
    public ImageVerificationCodeVO getLoginImageVerificationCode() {
        ImageVerificationCodeDO imageVerificationCode = verificationCodeService.getImageVerificationCode(VerificationCodeModel.LOGIN);
        return ToImageVerificationCodeVoConverter.CONVERTER.toImageVerificationCodeVo(imageVerificationCode);
    }

    /**
     * 发送登录验证码
     *
     * @param codeDto 验证码传输类
     */
    public void sendLoginVerificationCode(VerificationCodeDTO codeDto) {
        ImageVerificationCodeDO imageVerificationCodeDO = new ImageVerificationCodeDO();
        imageVerificationCodeDO.setUid(codeDto.getUid());
        imageVerificationCodeDO.setCode(codeDto.getCode());

        // 校验图片验证码是否正确
        boolean check = verificationCodeService.checkImageVerificationCode(imageVerificationCodeDO);
        if(!check) {
            throw new AssertionException(HttpStatus.BAD_REQUEST, 100001, messageSourceUtil.getMessage("100001"));
        }

        // 发送短信验证码
        MessageVerificationCodeDO codeDO = new MessageVerificationCodeDO(codeDto.getTo(), VerificationCodeModel.LOGIN);
        verificationCodeService.sendCode(codeDO);
    }
}
