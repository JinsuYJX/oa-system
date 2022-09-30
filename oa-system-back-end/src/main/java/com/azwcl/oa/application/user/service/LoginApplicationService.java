package com.azwcl.oa.application.user.service;

import com.azwcl.oa.application.user.converter.ToImageVerificationCodeVoConverter;
import com.azwcl.oa.domain.code.model.entity.ImageVerificationCodeDO;
import com.azwcl.oa.domain.code.model.enums.CodeType;
import com.azwcl.oa.domain.code.service.ImageVerificationCodeService;
import com.azwcl.oa.interfaces.user.vo.ImageVerificationCodeVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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


    /**
     * 获取登录图片验证码
     *
     * @return 登录图片验证码
     */
    public ImageVerificationCodeVO getLoginImageVerificationCode() {
        ImageVerificationCodeDO imageVerificationCodeDo = imageVerificationCodeService.getImageVerificationCodeDo(CodeType.LOGIN);
        return ToImageVerificationCodeVoConverter.CONVERTER.toImageVerificationCodeVo(imageVerificationCodeDo);
    }

}
