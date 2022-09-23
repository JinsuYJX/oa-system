package com.azwcl.oa.domain.code.repo;

import com.azwcl.oa.domain.code.entity.enums.MessageVerificationCodeType;
import com.azwcl.oa.domain.code.entity.enums.VerificationCodeModel;
import com.azwcl.oa.domain.code.repo.po.MessageVerificationCode;
import com.azwcl.oa.domain.repository.BaseRepo;

/**
 * 信息验证码 repo
 *
 * @author az
 * @date 2022/09/21
 */

public interface MessageVerificationCodeRepo extends BaseRepo<MessageVerificationCode> {
    /**
     * 获取 value
     *
     * @param to    接受者
     * @param model 模式
     * @param type  信息验证码类型
     * @return 返回对象
     */
    MessageVerificationCode getValue(String to, VerificationCodeModel model, MessageVerificationCodeType type);
}
