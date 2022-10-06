package com.azwcl.oa.application.user.converter;

import com.azwcl.oa.domain.person.repo.po.PersonAuth;
import com.azwcl.oa.interfaces.user.command.LoginCommand;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * --> PersonAuthConverter
 *
 * @author az
 * @date 2022/10/03
 * @see com.azwcl.oa.domain.person.repo.po.PersonAuth
 */

@Mapper
public interface ToPersonAuthConverter {
    ToPersonAuthConverter CONVERTER = Mappers.getMapper(ToPersonAuthConverter.class);

    /**
     * --> PersonAuth
     *
     * @param command  登录 command
     * @param authType 认证类型
     * @return PersonAuth
     */
    @Mapping(target = "username", source = "command.username")
    @Mapping(target = "password", source = "command.password")
    @Mapping(target = "authType", source = "authType")
    PersonAuth toPersonAuth(LoginCommand command, Integer authType);
}
