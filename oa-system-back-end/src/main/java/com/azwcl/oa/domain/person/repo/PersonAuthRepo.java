package com.azwcl.oa.domain.person.repo;

import com.azwcl.oa.domain.person.repo.po.PersonAuth;
import com.azwcl.oa.infrastructure.repo.BaseRepo;

/**
 * person_auth repo
 *
 * @author az
 * @date 2022/09/28
 */

public interface PersonAuthRepo extends BaseRepo<PersonAuth> {
    /**
     * 通过 username 查找
     * @param username username
     * @return 返回 person_auth 验证
     */
    PersonAuth getByUsername(String username);
}
