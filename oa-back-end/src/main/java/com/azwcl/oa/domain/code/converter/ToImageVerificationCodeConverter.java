package com.azwcl.oa.domain.code.converter;

import com.azwcl.oa.domain.code.entity.domainobject.ImageVerificationCodeDO;
import com.azwcl.oa.domain.code.entity.enums.VerificationCodeModel;
import com.azwcl.oa.domain.code.repo.po.ImageVerificationCode;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * -> ImageVerificationCode
 *
 * @author az
 * @date 2022/09/19
 */

@Mapper
public interface ToImageVerificationCodeConverter {
    ToImageVerificationCodeConverter CONVERTER = Mappers.getMapper(ToImageVerificationCodeConverter.class);

    /**
     * ImageVerificationCodeDO -> ImageVerificationCode
     *
     * @param code  ImageVerificationCodeDO
     * @param model VerificationCodeModel
     * @return ImageVerificationCode
     */
    @Mapping(target = "uid", source = "code.uid")
    @Mapping(target = "code", source = "code.code")
    @Mapping(target = "time", source = "code.time")
    @Mapping(target = "model", source = "model")
    ImageVerificationCode toImageVerificationCode(ImageVerificationCodeDO code, VerificationCodeModel model);
}
