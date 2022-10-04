package com.azwcl.oa.application.user.converter;

import com.azwcl.oa.domain.system.repo.po.SystemMenu;
import com.azwcl.oa.interfaces.user.vo.UserMenuVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * --> UserMenuVO
 *
 * @author az
 * @date 2022/10/04
 * @see com.azwcl.oa.interfaces.user.vo.UserMenuVO
 */

@Mapper
public interface ToUserMenuVoConverter {

    ToUserMenuVoConverter CONVERTER = Mappers.getMapper(ToUserMenuVoConverter.class);

    /**
     * --> UserMenuVO
     *
     * @param menu SystemMenu
     * @return UserMenuVo
     */
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "path", source = "path")
    @Mapping(target = "component", source = "component")
    @Mapping(target = "icon", source = "icon")
    @Mapping(target = "parentId", source = "parentId")
    UserMenuVO toUserMenuVo(SystemMenu menu);
}
