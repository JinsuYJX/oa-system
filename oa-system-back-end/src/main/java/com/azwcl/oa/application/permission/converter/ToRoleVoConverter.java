package com.azwcl.oa.application.permission.converter;

import com.azwcl.oa.domain.system.entity.SystemRoleDO;
import com.azwcl.oa.interfaces.permission.vo.RoleVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * --> RoleVO
 *
 * @author az
 * @date 2022/10/06
 * @see com.azwcl.oa.interfaces.permission.vo.RoleVO
 */

@Mapper
public interface ToRoleVoConverter {
    ToRoleVoConverter CONVERTER = Mappers.getMapper(ToRoleVoConverter.class);

    /**
     * --> RoleVO
     *
     * @param role SystemRoleDO
     * @return RoleVO
     */
    RoleVO toRoleVo(SystemRoleDO role);
}
