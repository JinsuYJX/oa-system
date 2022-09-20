package com.azwcl.oa.domain.code.service;

import com.azwcl.oa.domain.code.converter.ToImageVerificationCodeConverter;
import com.azwcl.oa.domain.code.entity.domainobject.ImageVerificationCodeDO;
import com.azwcl.oa.domain.code.entity.enums.VerificationCodeModel;
import com.azwcl.oa.domain.code.repo.ImageVerificationCodeRepo;
import com.azwcl.oa.infrastructure.common.enums.StringRandomModel;
import com.azwcl.oa.infrastructure.common.exception.AssertionException;
import com.azwcl.oa.infrastructure.utils.MessageProperties;
import com.azwcl.oa.infrastructure.utils.StringUtil;
import com.google.code.kaptcha.Producer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;
import org.springframework.util.FastByteArrayOutputStream;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;

/**
 * 图片验证码 service
 *
 * @author az
 * @date 2022/09/18
 */

@Service
@RequiredArgsConstructor
public class ImageVerificationCodeService {
    private final Producer kaptchaProducer;

    private final ImageVerificationCodeRepo imageVerificationCodeRepo;

    private final MessageProperties messageProperties;

    /**
     * 获取图片验证码
     *
     * @param model 获取模式
     * @return 返回图片验证码 DO
     */
    public ImageVerificationCodeDO getImageVerificationCode(VerificationCodeModel model) {

        // 随机生成 uid 和 验证码
        String uid = StringUtil.uuid();
        String code = StringUtil.random(4, StringRandomModel.ONLY_CHARACTER);

        // 生成验证码图片
        BufferedImage imageWriter = kaptchaProducer.createImage(code);
        FastByteArrayOutputStream fastByteArrayOutputStream = new FastByteArrayOutputStream();
        try {
            ImageIO.write(imageWriter, "png", fastByteArrayOutputStream);
        } catch (IOException e) {
            throw new AssertionException(200000, messageProperties.getMessage(200000));
        }
        String image = "data:image/png;base64," + Arrays.toString(Base64Utils.encode(fastByteArrayOutputStream.toByteArray()));

        // 构造
        ImageVerificationCodeDO codeDO = new ImageVerificationCodeDO(uid, code, image);

        // 存储
        imageVerificationCodeRepo.save(ToImageVerificationCodeConverter.CONVERTER.toImageVerificationCode(codeDO, model));

        return codeDO;
    }
}
