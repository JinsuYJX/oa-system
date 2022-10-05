package com.azwcl.oa.interfaces.permission.controller;

import com.azwcl.oa.application.permission.service.RoleManageApplicationService;
import com.azwcl.oa.interfaces.permission.dto.RoleCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * 角色管理 controller
 *
 * @author az
 * @date 2022/10/04
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/permission/role")
public class RoleManageController {
    private final RoleManageApplicationService roleManageApplicationService;

    /**
     * 创建角色
     *
     * @param command 角色 command
     * @param userId  用户 id
     * @return 返回角色序号
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Integer createRole(@RequestBody RoleCommand command, @RequestHeader("id") Integer userId) {
        return roleManageApplicationService.addNewRole(command, userId);
    }

    /**
     * 删除角色
     *
     * @param roleId 角色 id
     */

    @RequestMapping(value = "/{roleId}", method = RequestMethod.DELETE)
    public void deleteRole(@PathVariable("roleId") Integer roleId) {
        roleManageApplicationService.deleteRole(roleId);
    }
}
