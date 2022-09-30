package com.azwcl.oa.domain.code.repo;

import com.azwcl.oa.domain.code.repo.po.ImageVerificationCode;
import com.azwcl.oa.infrastructure.repo.BaseRepo;

/**
 * ImageVerificationCode
 *
 * @author az
 * @date 2022/09/29
 */

public interface ImageVerificationCodeRepo extends BaseRepo<ImageVerificationCode> {
    /**
     * 通过 uid 获取
     *
     * @param uid uid
     * @return 图片验证码
     */
    ImageVerificationCode getByUid(String uid);
}
