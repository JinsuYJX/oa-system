package com.azwcl.oa.application.user.service;

import com.azwcl.oa.application.user.converter.ToImageVerificationCodeVoConverter;
import com.azwcl.oa.domain.code.entity.domainobject.ImageVerificationCodeDO;
import com.azwcl.oa.domain.code.entity.enums.VerificationCodeModel;
import com.azwcl.oa.domain.code.service.ImageVerificationCodeService;
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
    private final ImageVerificationCodeService imageVerificationCodeService;

    /**
     * 获取登录图片验证码
     *
     * @return 图片验证码
     */
    public ImageVerificationCodeVO getLoginImageVerificationCode() {
        ImageVerificationCodeDO imageVerificationCode = imageVerificationCodeService.getImageVerificationCode(VerificationCodeModel.LOGIN);
        return ToImageVerificationCodeVoConverter.CONVERTER.toImageVerificationCodeVo(imageVerificationCode);
    }
}
