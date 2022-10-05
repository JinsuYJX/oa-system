package com.azwcl.oa.application.permission.converter;

import com.azwcl.oa.domain.system.repo.po.SystemRole;
import com.azwcl.oa.interfaces.permission.dto.RoleCommand;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * --> SystemRole
 *
 * @author az
 * @date 2022/10/05
 * @see com.azwcl.oa.domain.system.repo.po.SystemRole
 */

@Mapper
public interface ToSystemRoleConverter {

    ToSystemRoleConverter CONVERTER = Mappers.getMapper(ToSystemRoleConverter.class);


    /**
     * --> SystemRole
     * @param command RoleCommand
     * @param today 今天
     * @param time 时间
     * @param userId 用户 id
     * @return 返回
     */
    @Mapping(target = "id", source = "command.id")
    @Mapping(target = "name", source = "command.name")
    @Mapping(target = "describe", source = "command.describe")
    @Mapping(target = "createDate", source = "today")
    @Mapping(target = "createTime", source = "time")
    @Mapping(target = "createPerson", source = "userId")
    @Mapping(target = "updateDate", source = "today")
    @Mapping(target = "updateTime", source = "time")
    @Mapping(target = "updatePerson", source = "userId")
    @Mapping(target = "remark", source = "command.remark")
    SystemRole toSystemRole(RoleCommand command, Integer today, Integer time, Integer userId);
}
