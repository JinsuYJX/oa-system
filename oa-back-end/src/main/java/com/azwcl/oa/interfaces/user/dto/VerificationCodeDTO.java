package com.azwcl.oa.interfaces.user.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 验证码 dto
 *
 * @author az
 * @date 2022/09/21
 */

@Setter
@Getter
@ToString
public class VerificationCodeDTO extends ImageVerificationCodeDTO {
    /**
     * 发送对象
     */
    private String to;
}
