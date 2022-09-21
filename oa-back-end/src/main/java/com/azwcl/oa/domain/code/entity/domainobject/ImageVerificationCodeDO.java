package com.azwcl.oa.domain.code.entity.domainobject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 图片验证码 do
 *
 * @author az
 * @date 2022/09/18
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
     * 时间戳
     */
    private Long time;

    /**
     * 验证码
     */
    private String code;

    /**
     * 验证码图片
     */
    private String image;

    public ImageVerificationCodeDO() {
        this.time = System.currentTimeMillis();
    }

    public ImageVerificationCodeDO(String uid, String code, String image) {
        this.uid = uid;
        this.time = System.currentTimeMillis();
        this.code = code;
        this.image = image;
    }
}
