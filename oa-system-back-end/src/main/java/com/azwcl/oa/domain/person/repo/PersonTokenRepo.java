package com.azwcl.oa.domain.person.repo;

import com.azwcl.oa.domain.person.repo.po.PersonToken;
import com.azwcl.oa.infrastructure.repo.BaseRepo;

/**
 * 用户 token 仓储操作
 *
 * @author az
 * @date 2022/10/02
 */

public interface PersonTokenRepo extends BaseRepo<PersonToken> {

    /**
     * 通过 token 获取用户id
     *
     * @param token 登录 token
     * @return 返回用户 id
     */
    Integer getPersonIdByToken(String token);
}
