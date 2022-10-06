package com.azwcl.oa.domain.system.service;

import com.azwcl.oa.domain.system.repo.SystemMenuRepo;
import com.azwcl.oa.domain.system.repo.po.SystemMenu;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * 系统菜单 service
 *
 * @author az
 * @date 2022/10/04
 */

@Service
@RequiredArgsConstructor
public class SystemMenuService {
    private final SystemMenuRepo systemMenuRepo;

    /**
     * 获取角色菜单
     *
     * @param roles 角色
     * @return 菜单
     */
    public Collection<SystemMenu> getRoleMenu(Collection<Integer> roles) {
        return systemMenuRepo.getRoleMenu(roles);
    }

    /**
     * 获取默认菜单
     *
     * @return 默认菜单
     */
    public Collection<SystemMenu> getDefaultMenu() {
        return systemMenuRepo.getDefaultMenu();
    }
}
