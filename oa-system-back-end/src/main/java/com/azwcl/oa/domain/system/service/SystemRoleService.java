package com.azwcl.oa.domain.system.service;

import com.azwcl.oa.domain.system.repo.SystemRoleMenuRepo;
import com.azwcl.oa.domain.system.repo.SystemRoleRepo;
import com.azwcl.oa.domain.system.repo.SystemRoleResourceRepo;
import com.azwcl.oa.domain.system.repo.po.SystemRole;
import com.azwcl.oa.domain.system.repo.po.SystemRoleMenu;
import com.azwcl.oa.domain.system.repo.po.SystemRoleResource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 系统角色 service
 *
 * @author az
 * @date 2022/10/05
 */

@Service
@RequiredArgsConstructor
public class SystemRoleService {
    private final SystemRoleRepo systemRoleRepo;

    private final SystemRoleMenuRepo systemRoleMenuRepo;

    private final SystemRoleResourceRepo systemRoleResourceRepo;

    /**
     * 新增一个新角色
     *
     * @param role 角色
     * @return 返回角色 id
     */
    public Integer addNewRole(SystemRole role) {
        systemRoleRepo.save(role);
        return role.getId();
    }

    /**
     * 保存角色菜单
     *
     * @param roleMenus 角色菜单
     */
    public void saveRoleMenu(Collection<SystemRoleMenu> roleMenus) {
        systemRoleMenuRepo.saveAll(roleMenus);
    }

    /**
     * 保存角色资源
     *
     * @param roleResources 角色资源
     */
    public void saveRoleResource(Collection<SystemRoleResource> roleResources) {
        systemRoleResourceRepo.saveAll(roleResources);
    }

    public void deleteRole(Collection<Number> roles) {
        systemRoleMenuRepo.deleteByRole(roles);
        systemRoleResourceRepo.deleteByRole(roles);
        systemRoleRepo.deleteByIds(new ArrayList<>(roles));
    }
}
