package com.azwcl.oa.domain.person.repo.redis;

import com.azwcl.oa.domain.person.repo.PersonTokenRepo;
import com.azwcl.oa.domain.person.repo.po.PersonToken;
import com.azwcl.oa.infrastructure.utils.RedisCache;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Objects;

/**
 * 用户 token 的 redis 操作类
 *
 * @author az
 * @date 2022/10/02
 */

@Repository
@RequiredArgsConstructor
public class PersonTokenRepoRedisImpl implements PersonTokenRepo {

    private final static String TABLE_NAME = "PersonToken";
    private final static String TABLE_NAME_INDEX_PERSON_ID = "PersonTokenIndexPersonId";


    private final RedisCache redisCache;

    @Override
    public void save(PersonToken personToken) {
        redisCache.setHashValue(TABLE_NAME, personToken.getToken(), personToken);
        redisCache.setHashValue(TABLE_NAME_INDEX_PERSON_ID, personToken.getPersonId(), personToken);
    }

    @Override
    public Integer getPersonIdByToken(String token) {
        PersonToken personToken = redisCache.getHashValue(TABLE_NAME, token, PersonToken.class);
        if(Objects.isNull(personToken)) {
            return null;
        }
        return personToken.getPersonId();
    }
}
