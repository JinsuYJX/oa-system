package com.azwcl.oa.domain.person.repo;

import com.azwcl.oa.domain.person.entity.UserRolesDO;
import com.azwcl.oa.domain.person.repo.po.PersonRole;
import com.azwcl.oa.infrastructure.repo.BaseRepo;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 用户角色 repo
 *
 * @author az
 * @date 2022/10/02
 */

public interface PersonRoleRepo extends BaseRepo<PersonRole> {

    /**
     * 通过用户id获取用户角色do
     *
     * @param id 用户id
     * @return 用户角色 do
     */
    default UserRolesDO getUserRoleDoByPersonId(Number id) {
        return null;
    }

    /**
     * 保存用户角色
     *
     * @param userRoles 用户角色
     */
    default void saveUserRolesDo(UserRolesDO userRoles) {

    }

    /**
     * 通过用户 id 获取用户角色
     *
     * @param id 用户 id
     * @return 用户角色
     */
    default UserRolesDO getAlreadyLoginPersonRolesByPersonId(Number id) {
        return null;
    }

    /**
     * 通过角色获取
     *
     * @param roles 角色 id
     * @return 返回
     */
    default List<PersonRole> getByRoles(Collection<Integer> roles) {
        return Collections.emptyList();
    }
}
