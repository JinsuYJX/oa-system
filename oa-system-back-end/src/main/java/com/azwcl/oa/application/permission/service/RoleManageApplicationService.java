package com.azwcl.oa.application.permission.service;

import com.azwcl.oa.application.permission.converter.ToSystemRoleConverter;
import com.azwcl.oa.domain.system.repo.po.SystemMenu;
import com.azwcl.oa.domain.system.repo.po.SystemResource;
import com.azwcl.oa.domain.system.repo.po.SystemRole;
import com.azwcl.oa.domain.system.repo.po.SystemRoleMenu;
import com.azwcl.oa.domain.system.repo.po.SystemRoleResource;
import com.azwcl.oa.domain.system.service.SystemMenuService;
import com.azwcl.oa.domain.system.service.SystemResourceService;
import com.azwcl.oa.domain.system.service.SystemRoleService;
import com.azwcl.oa.infrastructure.common.enums.BooleanValue;
import com.azwcl.oa.infrastructure.utils.TimeUtil;
import com.azwcl.oa.interfaces.permission.dto.RoleCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 角色管理 application service
 *
 * @author az
 * @date 2022/10/04
 */

@Service
@RequiredArgsConstructor
public class RoleManageApplicationService {
    private final SystemRoleService systemRoleService;

    private final SystemMenuService systemMenuService;

    private final SystemResourceService systemResourceService;

    /**
     * 添加一个新角色
     *
     * @param command 角色 command
     * @param userId 用户 id
     * @return 返回新角色
     */
    @Transactional(rollbackFor = Exception.class)
    public Integer addNewRole(RoleCommand command, Integer userId) {
        // 添加新角色
        SystemRole systemRole = ToSystemRoleConverter.CONVERTER.toSystemRole(command, TimeUtil.getTodayDate(), TimeUtil.getNowTime(), userId);
        Integer roleId = systemRoleService.addNewRole(systemRole);

        // 查询默认菜单
        Collection<SystemMenu> defaultMenu = systemMenuService.getDefaultMenu();

        // 查询默认权限
        Collection<SystemResource> defaultResource = systemResourceService.getDefaultResource();

        // 赋权给新角色
        List<SystemRoleMenu> roleMenus = defaultMenu
                .stream()
                .map(obj -> new SystemRoleMenu(roleId, obj.getId(), BooleanValue.TRUE.getValueInt()))
                .collect(Collectors.toList());
        List<SystemRoleResource> roleResources = defaultResource
                .stream()
                .map(obj -> new SystemRoleResource(roleId, obj.getId(), BooleanValue.TRUE.getValueInt()))
                .collect(Collectors.toList());

        systemRoleService.saveRoleMenu(roleMenus);
        systemRoleService.saveRoleResource(roleResources);
        return roleId;
    }
}
