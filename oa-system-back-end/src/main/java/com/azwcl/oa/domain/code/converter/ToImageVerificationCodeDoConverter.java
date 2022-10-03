package com.azwcl.oa.domain.code.converter;

import com.azwcl.oa.domain.code.model.entity.ImageVerificationCodeDO;
import com.azwcl.oa.domain.code.repo.po.ImageVerificationCode;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * --> ImageVerificationCodeDO
 *
 * @author az
 * @date 2022/10/02
 * @see com.azwcl.oa.domain.code.model.entity.ImageVerificationCodeDO
 */

@Mapper
public interface ToImageVerificationCodeDoConverter {
    ToImageVerificationCodeDoConverter CONVERTER = Mappers.getMapper(ToImageVerificationCodeDoConverter.class);

    /**
     * --> ImageVerificationCodeDO
     *
     * @param code ImageVerificationCode
     * @return ImageVerificationCodeDO
     */
    @Mapping(target = "uid", source = "uid")
    @Mapping(target = "code", source = "code")
    @Mapping(target = "type", source = "type")
    ImageVerificationCodeDO toImageVerificationCodeDo(ImageVerificationCode code);
}
