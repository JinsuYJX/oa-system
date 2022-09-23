package com.azwcl.oa.domain.code.repo.redis;

import com.azwcl.oa.domain.code.repo.ImageVerificationCodeRepo;
import com.azwcl.oa.domain.code.repo.po.ImageVerificationCode;
import com.azwcl.oa.infrastructure.utils.JsonSerialize;
import com.azwcl.oa.infrastructure.utils.RedisCache;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Repository;

import java.util.Objects;

/**
 * ImageVerificationCodeRepo redis 实现
 *
 * @author az
 * @date 2022/09/18
 */
@Repository
@RequiredArgsConstructor
public class ImageVerificationCodeRepoRedisImpl implements ImageVerificationCodeRepo {
    private final RedisCache redisCache;

    private final JsonSerialize jsonSerialize;

    private final ObjectMapper objectMapper;
    private final String tableName = "ImageVerificationCode";

    @Override
    public void save(ImageVerificationCode imageVerificationCode) {
        redisCache.setHashValue(tableName, imageVerificationCode.getUid(), jsonSerialize.getJson(imageVerificationCode));
    }

    /**
     * 通过 uid 删除
     *
     * @param uid uid
     */
    @Override
    public void deleteByUid(String uid) {
        redisCache.deleteHashValue(tableName, uid);
    }

    @Override
    @SneakyThrows
    public ImageVerificationCode findByUid(String uid) {
        return redisCache.getHashValue(tableName, uid, ImageVerificationCode.class);
    }
}
