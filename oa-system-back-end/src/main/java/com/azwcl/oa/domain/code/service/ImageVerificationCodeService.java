package com.azwcl.oa.domain.code.service;

import com.azwcl.oa.domain.code.converter.ToImageVerificationCodeConverter;
import com.azwcl.oa.domain.code.model.entity.ImageVerificationCodeDO;
import com.azwcl.oa.domain.code.model.enums.CodeType;
import com.azwcl.oa.domain.code.repo.ImageVerificationCodeRepo;
import com.azwcl.oa.domain.code.repo.po.ImageVerificationCode;
import com.azwcl.oa.infrastructure.utils.MessageSourceUtil;
import com.google.code.kaptcha.Producer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 图片验证码 Service
 *
 * @author az
 * @date 2022/09/29
 */

@Service
@RequiredArgsConstructor
public class ImageVerificationCodeService {

    private final ImageVerificationCodeRepo imageVerificationCodeRepo;

    private final Producer kaptchaProducer;

    private final MessageSourceUtil messageSourceUtil;


    /**
     * 获取图片验证码
     *
     * @return 图片验证码
     */
    public ImageVerificationCodeDO getImageVerificationCodeDo(CodeType type) {
        // 生成图片验证码 DO
        ImageVerificationCodeDO codeDo = new ImageVerificationCodeDO();
        codeDo.generateImageVerificationCodeDo(kaptchaProducer, messageSourceUtil, type);

        // 存储
        ImageVerificationCode code = ToImageVerificationCodeConverter.CONVERTER.toImageVerificationCode(codeDo);

        this.imageVerificationCodeRepo.save(code);

        return codeDo;
    }
}
