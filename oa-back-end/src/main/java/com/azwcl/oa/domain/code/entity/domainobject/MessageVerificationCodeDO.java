package com.azwcl.oa.domain.code.entity.domainobject;

import com.azwcl.oa.domain.code.entity.enums.VerificationCodeModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 信息验证码 domain object
 *
 * @author az
 * @date 2022/09/21
 */

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MessageVerificationCodeDO {
    /**
     * 发送对象
     */
    private String to;

    /**
     * 验证码模式
     */
    private VerificationCodeModel model;
}
