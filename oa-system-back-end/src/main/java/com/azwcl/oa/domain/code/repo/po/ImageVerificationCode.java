package com.azwcl.oa.domain.code.repo.po;

import com.azwcl.oa.domain.code.model.enums.CodeType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 验证码 service
 *
 * @author az
 * @date 2022/09/28
 */

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class ImageVerificationCode {

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
}
