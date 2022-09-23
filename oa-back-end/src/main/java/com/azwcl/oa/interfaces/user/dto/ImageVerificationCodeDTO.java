package com.azwcl.oa.interfaces.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 图片验证码
 *
 * @author az
 * @date 2022/09/21
 */

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ImageVerificationCodeDTO {
    /**
     * 图片验证码 uid
     */
    String uid;

    /**
     * 验证码
     */
    String code;
}
