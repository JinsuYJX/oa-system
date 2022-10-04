package com.azwcl.oa.domain.system.repo;

import com.azwcl.oa.domain.system.repo.po.SystemMenu;
import com.azwcl.oa.infrastructure.repo.BaseRepo;

import java.util.Collection;

/**
 * system_menu
 *
 * @author az
 * @date 2022/10/04
 */

public interface SystemMenuRepo extends BaseRepo<SystemMenu> {

    /**
     * 获取角色下的菜单
     *
     * @param roleId 角色id集合
     * @return 菜单
     */
    Collection<SystemMenu> getRoleMenu(Collection<Integer> roleId);
}
