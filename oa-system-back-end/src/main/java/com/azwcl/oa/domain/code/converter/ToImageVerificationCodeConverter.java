package com.azwcl.oa.domain.code.converter;

import com.azwcl.oa.domain.code.model.entity.ImageVerificationCodeDO;
import com.azwcl.oa.domain.code.repo.po.ImageVerificationCode;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * --> ImageVerificationCode
 *
 * @author az
 * @date 2022/09/29
 * @see com.azwcl.oa.domain.code.repo.po.ImageVerificationCode
 */

@Mapper
public interface ToImageVerificationCodeConverter {
    ToImageVerificationCodeConverter CONVERTER = Mappers.getMapper(ToImageVerificationCodeConverter.class);


    /**
     * --> ImageVerificationCode
     *
     * @param codeDO ImageVerificationDO
     * @return ImageVerificationCode
     */
    @Mapping(target = "uid", source = "uid")
    @Mapping(target = "code", source = "code")
    @Mapping(target = "time", source = "time")
    @Mapping(target = "type", source = "type")
    ImageVerificationCode toImageVerificationCode(ImageVerificationCodeDO codeDO);
}
