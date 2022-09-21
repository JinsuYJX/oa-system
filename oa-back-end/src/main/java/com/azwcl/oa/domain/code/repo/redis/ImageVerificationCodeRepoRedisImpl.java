package com.azwcl.oa.domain.code.repo.redis;

import com.azwcl.oa.domain.code.repo.ImageVerificationCodeRepo;
import com.azwcl.oa.domain.code.repo.po.ImageVerificationCode;
import com.azwcl.oa.infrastructure.utils.RedisCache;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
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

    private final ObjectMapper objectMapper;

    private final String tableName = "ImageVerificationCode";

    @Override
    public void save(ImageVerificationCode imageVerificationCode) {
        redisCache.setHashValue(tableName, imageVerificationCode.getUid(), imageVerificationCode);
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
    public ImageVerificationCode findByUid(String uid) {
        Object hashValue = redisCache.getHashValue(tableName, uid);
        if(Objects.isNull(hashValue)) {
            return null;
        }
        else {
            return (ImageVerificationCode) hashValue;
        }
    }
}
