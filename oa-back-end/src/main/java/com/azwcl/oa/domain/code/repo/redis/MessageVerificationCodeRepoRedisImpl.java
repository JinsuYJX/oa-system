package com.azwcl.oa.domain.code.repo.redis;

import com.azwcl.oa.domain.code.entity.enums.MessageVerificationCodeType;
import com.azwcl.oa.domain.code.entity.enums.VerificationCodeModel;
import com.azwcl.oa.domain.code.repo.MessageVerificationCodeRepo;
import com.azwcl.oa.domain.code.repo.po.MessageVerificationCode;
import com.azwcl.oa.infrastructure.utils.JsonSerialize;
import com.azwcl.oa.infrastructure.utils.RedisCache;
import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;


/**
 * 消息验证码 repo redis 实现类
 *
 * @author az
 * @date 2022/09/21
 */

@Repository
@RequiredArgsConstructor
public class MessageVerificationCodeRepoRedisImpl implements MessageVerificationCodeRepo {

    private final RedisCache redisCache;

    private final JsonSerialize jsonSerialize;

    private final String tableName = "MessageVerificationCode";

    @Override
    public void save(MessageVerificationCode code) {
        redisCache.setHashValue(tableName, code.getTo(), Lists.newArrayList(code));
    }

    @Override
    public MessageVerificationCode getValue(String to, VerificationCodeModel model, MessageVerificationCodeType type) {
        return redisCache.getHashValue(tableName, getKey(to, model, type), MessageVerificationCode.class);
    }

    /**
     * 获取 key 键
     *
     * @param code 信息验证码
     * @return 返回
     */
    private String getKey(MessageVerificationCode code) {
        return code.getTo() + "-" + code.getModel().getModel() + "-" + code.getType().getType();
    }

    /**
     * 获取 key 键
     *
     * @param to    发件人
     * @param model 验证码模式
     * @param type  信息验证码类型
     * @return key 键
     */
    private String getKey(String to, VerificationCodeModel model, MessageVerificationCodeType type) {
        return to + "-" + model.getModel() + "-" + type.getType();
    }
}
