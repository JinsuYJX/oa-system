package com.azwcl.oa.domain.code.repo.po;

import com.azwcl.oa.domain.code.entity.enums.VerificationCodeModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 图片验证码
 *
 * @author az
 * @date 2022/09/18
 */

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ImageVerificationCode {

    /**
     * uid
     */
    private String uid;

    /**
     * 验证码
     */
    private String code;

    /**
     * 时间戳
     */
    private Long time;

    /**
     * 模式
     */
    private VerificationCodeModel model;
}
