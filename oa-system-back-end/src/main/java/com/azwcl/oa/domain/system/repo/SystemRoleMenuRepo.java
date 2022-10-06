package com.azwcl.oa.domain.system.repo;

import com.azwcl.oa.domain.system.repo.po.SystemRoleMenu;
import com.azwcl.oa.infrastructure.repo.BaseRepo;

import java.util.Collection;

/**
 * system_role_menu repo
 *
 * @author az
 * @date 2022/10/05
 */

public interface SystemRoleMenuRepo extends BaseRepo<SystemRoleMenu> {
    /**
     * 通过角色id集合删除角色菜单
     *
     * @param roles 角色id集合
     */
    void deleteByRole(Collection<Number> roles);
}
