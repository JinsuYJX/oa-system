package com.azwcl.oa.domain.person.converter;

import com.azwcl.oa.domain.person.entity.UserDetailsDO;
import com.azwcl.oa.domain.person.repo.po.PersonAuth;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * --> UserDetailsDO
 *
 * @author az
 * @date 2022/09/28
 */

@Mapper
public interface ToUserDetailsDoConverter {
    ToUserDetailsDoConverter CONVERTER = Mappers.getMapper(ToUserDetailsDoConverter.class);

    /**
     * --> UserDetailsDO
     * @param personAuth PersonAuth
     * @return UserDetailsDO
     */
    @Mapping(target = "personId", source = "personId")
    @Mapping(target = "username", source = "username")
    @Mapping(target = "password", source = "password")
    UserDetailsDO toUserDetailsDo (PersonAuth personAuth);
}
