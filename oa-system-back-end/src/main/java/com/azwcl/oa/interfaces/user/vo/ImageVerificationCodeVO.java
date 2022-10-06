package com.azwcl.oa.interfaces.user.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 图片验证码 vo
 *
 * @author az
 * @date 2022/09/28
 */

@Getter
@Setter
@ToString
public class ImageVerificationCodeVO {
    /**
     * 图片 uid
     */
    private String uid;

    /**
     * 图片
     */
    private String image;
}
