package com.azwcl.oa.domain.person.repo.db;

import com.azwcl.oa.domain.person.entity.UserRolesDO;
import com.azwcl.oa.domain.person.repo.PersonRoleRepo;
import com.azwcl.oa.domain.person.repo.mapper.PersonRoleMapper;
import com.azwcl.oa.domain.person.repo.po.PersonRole;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户角色 repo db impl
 *
 * @author az
 * @date 2022/10/02
 */

@Repository("PersonRoleRepoDbImpl")
@RequiredArgsConstructor
public class PersonRoleRepoDbImpl implements PersonRoleRepo {
    private final PersonRoleMapper personRoleMapper;

    @Override
    public UserRolesDO getUserRoleDoByPersonId(Number id) {
        LambdaQueryWrapper<PersonRole> queryWrapper = new LambdaQueryWrapper<PersonRole>()
                .eq(PersonRole::getPersonId, id);
        List<PersonRole> personRoles = personRoleMapper.selectList(queryWrapper);

        List<Integer> roles = personRoles
                .stream()
                .map(PersonRole::getRoleId)
                .collect(Collectors.toList());

        return new UserRolesDO(id.intValue(), roles);
    }

    @Override
    public List<PersonRole> getByRoles(Collection<Integer> roles) {
        LambdaQueryWrapper<PersonRole> queryWrapper = new LambdaQueryWrapper<PersonRole>()
                .in(PersonRole::getRoleId, roles);
        return personRoleMapper.selectList(queryWrapper);
    }
}
