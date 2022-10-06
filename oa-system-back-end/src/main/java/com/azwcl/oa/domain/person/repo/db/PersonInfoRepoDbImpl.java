package com.azwcl.oa.domain.person.repo.db;

import com.azwcl.oa.domain.person.repo.PersonInfoRepo;
import com.azwcl.oa.domain.person.repo.mapper.PersonInfoMapper;
import com.azwcl.oa.domain.person.repo.po.PersonInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * person_info repo db impl
 *
 * @author az
 * @date 2022/10/03
 */

@Repository
@RequiredArgsConstructor
public class PersonInfoRepoDbImpl implements PersonInfoRepo {

    private final PersonInfoMapper personInfoMapper;

    @Override
    public PersonInfo getById(Number id) {
        return personInfoMapper.selectById(id);
    }
}
