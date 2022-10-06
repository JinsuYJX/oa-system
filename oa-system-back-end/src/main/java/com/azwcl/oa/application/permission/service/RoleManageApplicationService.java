package com.azwcl.oa.application.permission.service;

import com.azwcl.oa.application.permission.converter.ToRoleVoConverter;
import com.azwcl.oa.application.permission.converter.ToSystemRoleConverter;
import com.azwcl.oa.domain.person.repo.po.PersonRole;
import com.azwcl.oa.domain.person.service.PersonRoleService;
import com.azwcl.oa.domain.system.entity.SystemRoleDO;
import com.azwcl.oa.domain.system.repo.po.SystemMenu;
import com.azwcl.oa.domain.system.repo.po.SystemResource;
import com.azwcl.oa.domain.system.repo.po.SystemRole;
import com.azwcl.oa.domain.system.repo.po.SystemRoleMenu;
import com.azwcl.oa.domain.system.repo.po.SystemRoleResource;
import com.azwcl.oa.domain.system.service.SystemMenuService;
import com.azwcl.oa.domain.system.service.SystemResourceService;
import com.azwcl.oa.domain.system.service.SystemRoleService;
import com.azwcl.oa.infrastructure.common.enums.BooleanValue;
import com.azwcl.oa.infrastructure.common.model.Paging;
import com.azwcl.oa.infrastructure.exception.AssertionException;
import com.azwcl.oa.infrastructure.utils.MessageSourceUtil;
import com.azwcl.oa.infrastructure.utils.TimeUtil;
import com.azwcl.oa.interfaces.permission.dto.RoleCommand;
import com.azwcl.oa.interfaces.permission.query.RoleQuery;
import com.azwcl.oa.interfaces.permission.vo.RoleVO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Collections;
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

    private final PersonRoleService personRoleService;

    private final MessageSourceUtil messageSourceUtil;

    /**
     * 添加一个新角色
     *
     * @param command 角色 command
     * @param userId  用户 id
     * @return 返回新角色
     */
    @Transactional(rollbackFor = Exception.class)
    public Integer addNewRole(RoleCommand command, Integer userId) {
        // 添加新角色
        SystemRole systemRole = ToSystemRoleConverter.CONVERTER.toSystemRoleOfNew(command, TimeUtil.getTodayDate(), TimeUtil.getNowTime(), userId);
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

    /**
     * 删除角色
     *
     * @param roleId 角色 id
     */
    @Transactional(rollbackFor = Exception.class)
    public void deleteRole(Integer roleId) {
        // 角色下是否有使用人
        List<PersonRole> personRoles = personRoleService.getPersonRoleByRoleIds(Collections.singleton(roleId));
        if (!CollectionUtils.isEmpty(personRoles)) {
            Object[] args = new Object[]{personRoles.get(0).getRoleId(), personRoles.get(0).getPersonId()};
            throw new AssertionException(HttpStatus.INTERNAL_SERVER_ERROR.value(), messageSourceUtil.getMessage("500000", args));
        }

        // 删除该角色
        systemRoleService.deleteRole(Collections.singleton(roleId));
    }

    /**
     * 修改角色
     *
     * @param command RoleCommand
     * @param userId  角色 id
     */
    public void updateRole(RoleCommand command, Integer userId) {
        SystemRole role = ToSystemRoleConverter.CONVERTER.toSystemRoleOfUpdate(command, TimeUtil.getTodayDate(), TimeUtil.getNowTime(), userId);
        systemRoleService.updateRole(role);
    }

    /**
     * 查询角色
     *
     * @param query 查询器
     * @return 返回
     */
    public Paging<RoleVO> queryRoleList(RoleQuery query) {
        Paging<SystemRoleDO> queryResult = systemRoleService.querySystemRole(query);

        List<RoleVO> roles = queryResult.getRecords()
                .stream()
                .map(ToRoleVoConverter.CONVERTER::toRoleVo)
                .collect(Collectors.toList());

        return new Paging<>(query, queryResult.getTotal(), roles);
    }
}
