package com.azwcl.oa.domain.person.service;

import com.azwcl.oa.domain.person.repo.PersonRoleRepo;
import com.azwcl.oa.domain.person.repo.po.PersonRole;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

/**
 * 人员角色 service
 *
 * @author az
 * @date 2022/10/05
 */

@Service
@RequiredArgsConstructor
public class PersonRoleService {
    @Resource(name = "PersonRoleRepoDbImpl")
    private PersonRoleRepo personRoleDbRepo;

    /**
     * 通过角色 id 集合获取 person_role
     *
     * @param roles 角色id集合
     * @return 人员角色集合
     */

    public List<PersonRole> getPersonRoleByRoleIds(Collection<Integer> roles) {
        return personRoleDbRepo.getByRoles(roles);
    }
}
