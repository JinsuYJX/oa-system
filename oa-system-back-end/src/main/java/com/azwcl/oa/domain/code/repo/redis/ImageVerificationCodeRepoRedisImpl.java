package com.azwcl.oa.domain.code.repo.redis;

import com.azwcl.oa.domain.code.repo.ImageVerificationCodeRepo;
import com.azwcl.oa.domain.code.repo.po.ImageVerificationCode;
import com.azwcl.oa.infrastructure.utils.RedisCache;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Repository;

/**
 * 图片验证码 repo redis impl
 *
 * @author az
 * @date 2022/09/29
 */

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Repository
public class ImageVerificationCodeRepoRedisImpl implements ImageVerificationCodeRepo {
    private final RedisCache redisCache;

    @Override
    public void save(ImageVerificationCode imageVerificationCode) {
        redisCache.setHashValue(ImageVerificationCode.class.getSimpleName(), imageVerificationCode.getUid(), imageVerificationCode);
    }

    @Override
    public ImageVerificationCode getByUid(String uid) {
        return redisCache.getHashValue(ImageVerificationCode.class.getName(), uid, ImageVerificationCode.class);
    }
}
