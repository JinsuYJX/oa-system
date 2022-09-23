package com.azwcl.oa.domain.code.repo.po;

import com.azwcl.oa.domain.code.entity.enums.MessageVerificationCodeType;
import com.azwcl.oa.domain.code.entity.enums.VerificationCodeModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 信息验证码
 *
 * @author az
 * @date 2022/09/21
 */

@Getter
@Setter
@ToString
public class MessageVerificationCode {
    /**
     * 发送对象
     */
    private String to;

    /**
     * 验证码
     */
    private String code;

    /**
     * 时间戳
     */
    private Long time;

    /**
     * 验证码模式
     */
    private VerificationCodeModel model;

    /**
     * 消息验证码类型
     */
    private MessageVerificationCodeType type;

    public MessageVerificationCode() {
        this.time = System.currentTimeMillis();
    }
}
