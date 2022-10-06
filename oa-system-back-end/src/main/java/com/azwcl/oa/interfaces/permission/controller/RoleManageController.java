package com.azwcl.oa.interfaces.permission.controller;

import com.azwcl.oa.application.permission.service.RoleManageApplicationService;
import com.azwcl.oa.infrastructure.common.model.Paging;
import com.azwcl.oa.infrastructure.exception.AssertionException;
import com.azwcl.oa.infrastructure.utils.MessageSourceUtil;
import com.azwcl.oa.interfaces.permission.dto.RoleCommand;
import com.azwcl.oa.interfaces.permission.query.RoleQuery;
import com.azwcl.oa.interfaces.permission.vo.RoleVO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

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

    private final MessageSourceUtil messageSourceUtil;

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

    /**
     * 修改角色
     *
     * @param command 角色command
     * @param roleId  角色 id
     * @param userId  用户 id
     */
    @RequestMapping(value = "/{roleId}", method = RequestMethod.PUT)
    public void updateRole(@RequestBody RoleCommand command, @PathVariable("roleId") Integer roleId, @RequestHeader("id") Integer userId) {
        command.setId(roleId);
        roleManageApplicationService.updateRole(command, userId);
    }

    /**
     * 查询角色列表
     *
     * @param query 查询器
     * @return 角色列表
     */
    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public Paging<RoleVO> queryRoleList(@RequestBody(required = false) RoleQuery query) {
        if (Objects.isNull(query)) {
            query = new RoleQuery();
        }
        if (Objects.isNull(query.getPageSize()) || Objects.isNull(query.getPageNumber())) {
            throw new AssertionException(HttpStatus.BAD_REQUEST.value(), messageSourceUtil.getMessage("100006"));
        }
        return roleManageApplicationService.queryRoleList(query);
    }
}
