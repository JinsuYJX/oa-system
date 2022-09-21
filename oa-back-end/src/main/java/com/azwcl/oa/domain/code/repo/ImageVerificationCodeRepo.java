package com.azwcl.oa.domain.code.repo;

import com.azwcl.oa.domain.code.repo.po.ImageVerificationCode;
import com.azwcl.oa.domain.repository.BaseRepo;

/**
 * 图片验证码 repo
 *
 * @author az
 * @date 2022/09/18
 */

public interface ImageVerificationCodeRepo extends BaseRepo<ImageVerificationCode> {

    /**
     * 通过 uid 删除
     *
     * @param uid uid
     */
    void deleteByUid(String uid);

    /**
     * 通过 uid 查询
     *
     * @param uid uid
     * @return 查找的对象
     */
    ImageVerificationCode findByUid(String uid);
}
