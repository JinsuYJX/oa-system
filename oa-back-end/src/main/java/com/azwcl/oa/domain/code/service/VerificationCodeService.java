package com.azwcl.oa.domain.code.service;

import com.azwcl.oa.domain.code.converter.ToImageVerificationCodeConverter;
import com.azwcl.oa.domain.code.converter.ToMessageVerificationCodeConverter;
import com.azwcl.oa.domain.code.entity.domainobject.ImageVerificationCodeDO;
import com.azwcl.oa.domain.code.entity.domainobject.MessageVerificationCodeDO;
import com.azwcl.oa.domain.code.entity.enums.MessageVerificationCodeType;
import com.azwcl.oa.domain.code.entity.enums.VerificationCodeModel;
import com.azwcl.oa.domain.code.repo.ImageVerificationCodeRepo;
import com.azwcl.oa.domain.code.repo.MessageVerificationCodeRepo;
import com.azwcl.oa.domain.code.repo.po.ImageVerificationCode;
import com.azwcl.oa.domain.code.repo.po.MessageVerificationCode;
import com.azwcl.oa.infrastructure.client.EmailClient;
import com.azwcl.oa.infrastructure.common.enums.ExpirationTime;
import com.azwcl.oa.infrastructure.common.enums.HttpStatus;
import com.azwcl.oa.infrastructure.common.enums.StringRandomModel;
import com.azwcl.oa.infrastructure.common.exception.AssertionException;
import com.azwcl.oa.infrastructure.utils.MessageSourceUtil;
import com.azwcl.oa.infrastructure.utils.StringUtil;
import com.google.code.kaptcha.Producer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;
import org.springframework.util.FastByteArrayOutputStream;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

/**
 * 验证码 service
 *
 * @author az
 * @date 2022/09/18
 */

@Service
@RequiredArgsConstructor
public class VerificationCodeService {
    private final Producer kaptchaProducer;

    private final ImageVerificationCodeRepo imageVerificationCodeRepo;

    private final MessageVerificationCodeRepo messageVerificationCodeRepo;

    private final MessageSourceUtil messageSourceUtil;

    private final EmailClient emailClient;

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
            throw new AssertionException(200001, messageSourceUtil.getMessage("200001"));
        }
        String image = "data:image/png;base64," + new String(Base64Utils.encode(fastByteArrayOutputStream.toByteArray()));

        // 构造
        ImageVerificationCodeDO codeDO = new ImageVerificationCodeDO(uid, code, image);

        // 存储
        imageVerificationCodeRepo.save(ToImageVerificationCodeConverter.CONVERTER.toImageVerificationCode(codeDO, model));

        return codeDO;
    }

    /**
     * 检查图片验证码
     *
     * @param codeDO 验证码
     * @return 验证码处理结果
     */
    public boolean checkImageVerificationCode(ImageVerificationCodeDO codeDO) {
        ImageVerificationCode cacheCode = imageVerificationCodeRepo.findByUid(codeDO.getUid());
        if (cacheCode == null) {
            throw new AssertionException(HttpStatus.BAD_REQUEST, 100000, messageSourceUtil.getMessage("100000"));
        }

        if(codeDO.getTime() - cacheCode.getTime() > ExpirationTime.VERIFICATION_CODE.getMillisecond()) {
            throw new AssertionException(HttpStatus.BAD_REQUEST, 100000, messageSourceUtil.getMessage("100000"));
        }

        return Objects.equals(cacheCode.getCode().toUpperCase(), codeDO.getCode().toUpperCase());
    }

    /**
     * 发送邮件验证码
     */
    public void sendCode(MessageVerificationCodeDO codeDo) {
        // 生成验证码
        String randomCode = StringUtil.random(6, StringRandomModel.ONLY_NUMBER);
        MessageVerificationCodeType codeType = MessageVerificationCodeType.UNKNOWN;
        if(StringUtil.isEmail(codeDo.getTo())) {
            codeType = MessageVerificationCodeType.EMAIL;
        }
        MessageVerificationCode code = ToMessageVerificationCodeConverter.CONVERTER.toMessageVerificationCode(codeDo, randomCode, codeType);
        messageVerificationCodeRepo.save(code);
        sendCode(code);
    }

    /**
     * 发送验证码
     *
     * @param code 验证码
     */
    private void sendCode(MessageVerificationCode code) {
        switch (code.getType()) {
            case EMAIL: {
                Object[] args = new Object[]{code.getCode(), ExpirationTime.VERIFICATION_CODE.getMinutes()};
                emailClient.sendSimpleMail(code.getTo(), messageSourceUtil.getMessage("500000"), messageSourceUtil.getMessage("500001", args));
                break;
            }
            default:
        }
    }
}
