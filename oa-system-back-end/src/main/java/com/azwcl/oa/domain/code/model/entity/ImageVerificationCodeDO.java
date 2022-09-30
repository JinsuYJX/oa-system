package com.azwcl.oa.domain.code.model.entity;

import com.azwcl.oa.domain.code.model.enums.CodeType;
import com.azwcl.oa.infrastructure.common.enums.StringRandomModel;
import com.azwcl.oa.infrastructure.exception.AssertionException;
import com.azwcl.oa.infrastructure.utils.MessageSourceUtil;
import com.azwcl.oa.infrastructure.utils.StringUtil;
import com.google.code.kaptcha.Producer;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.util.Base64Utils;
import org.springframework.util.FastByteArrayOutputStream;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 图片验证码 do
 *
 * @author az
 * @date 2022/09/29
 */

@Getter
@Setter
@ToString
public class ImageVerificationCodeDO {
    /**
     * uid
     */
    private String uid;

    /**
     * 生成的 code
     */
    private String code;

    /**
     * 时间
     */
    private Long time;

    /**
     * code type
     */
    private CodeType type;

    /**
     * 生成的图片
     */
    private String image;


    /**
     * 生成图片验证码 DO
     *
     * @param producer          图片验证码生成器
     * @param messageSourceUtil MessageSource
     * @return 返回图片验证码
     */
    public ImageVerificationCodeDO generateImageVerificationCodeDo(Producer producer, MessageSourceUtil messageSourceUtil, CodeType type) {
        this.uid = StringUtil.uuid();
        this.code = StringUtil.random(4, StringRandomModel.ONLY_CHARACTER);
        this.time = System.currentTimeMillis();
        this.type = type;
        BufferedImage bufferedImage = producer.createImage(code);
        FastByteArrayOutputStream outputStream = new FastByteArrayOutputStream();
        try {
            ImageIO.write(bufferedImage, "png", outputStream);
        } catch (IOException e) {
            throw new AssertionException(200001, messageSourceUtil.getMessage("200001"));
        }
        this.image = "data:image/png;base64," + new String(Base64Utils.encode(outputStream.toByteArray()));

        return this;
    }
}
