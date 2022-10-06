package com.azwcl.oa.domain.person.repo.db;

import com.azwcl.oa.domain.person.repo.PersonAuthRepo;
import com.azwcl.oa.domain.person.repo.mapper.PersonAuthMapper;
import com.azwcl.oa.domain.person.repo.po.PersonAuth;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * person_auth table repo db impl
 *
 * @author az
 * @date 2022/09/28
 */

@Repository
@RequiredArgsConstructor
public class PersonAuthRepoDbImpl implements PersonAuthRepo {

    private final PersonAuthMapper personAuthMapper;

    @Override
    public PersonAuth getByUsername(String username) {
        LambdaQueryWrapper<PersonAuth> queryWrapper = new LambdaQueryWrapper<PersonAuth>()
                .eq(PersonAuth::getUsername, username);
        return personAuthMapper.selectOne(queryWrapper);
    }
}
