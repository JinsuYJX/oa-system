package com.azwcl.oa.domain.person.repo.redis;

import com.azwcl.oa.domain.person.entity.UserRolesDO;
import com.azwcl.oa.domain.person.repo.PersonRoleRepo;
import com.azwcl.oa.domain.person.repo.po.PersonRole;
import com.azwcl.oa.infrastructure.utils.RedisCache;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * 用户角色 repo redis impl
 *
 * @author az
 * @date 2022/10/02
 */

@Repository
@RequiredArgsConstructor
public class PersonRoleRepoRedisImpl implements PersonRoleRepo {

    private final RedisCache redisCache;

    @Override
    public void saveAlreadyLoginPerson(UserRolesDO userRoles) {
        redisCache.setHashValue(PersonRole.class.getSimpleName(), userRoles.getPersonId(), UserRolesDO.class);
    }

    @Override
    public UserRolesDO getAlreadyLoginPersonRolesByPersonId(Number id) {
        return redisCache.getHashValue(PersonRole.class.getSimpleName(), id, UserRolesDO.class);
    }
}
