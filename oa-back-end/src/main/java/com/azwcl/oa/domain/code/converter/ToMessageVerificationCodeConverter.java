package com.azwcl.oa.domain.code.converter;

import com.azwcl.oa.domain.code.entity.domainobject.MessageVerificationCodeDO;
import com.azwcl.oa.domain.code.entity.enums.MessageVerificationCodeType;
import com.azwcl.oa.domain.code.repo.po.MessageVerificationCode;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * --> MessageVerificationCode
 *
 * @author az
 * @date 2022/09/21
 */

@Mapper
public interface ToMessageVerificationCodeConverter {
    ToMessageVerificationCodeConverter CONVERTER = Mappers.getMapper(ToMessageVerificationCodeConverter.class);

    /**
     * --> toMessageVerificationCode
     *
     * @param codeDo 验证码 domain object
     * @param code   验证码
     * @param type   消息验证码类型
     * @return MessageVerificationCOde
     */
    @Mapping(target = "to", source = "codeDo.to")
    @Mapping(target = "code", source = "code")
    @Mapping(target = "time", ignore = true)
    @Mapping(target = "model", source = "codeDo.model")
    @Mapping(target = "type", source = "type")
    MessageVerificationCode toMessageVerificationCode(MessageVerificationCodeDO codeDo, String code, MessageVerificationCodeType type);
}
