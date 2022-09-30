package com.azwcl.oa.application.user.converter;

import com.azwcl.oa.domain.code.model.entity.ImageVerificationCodeDO;
import com.azwcl.oa.interfaces.user.vo.ImageVerificationCodeVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * --> ImageVerificationVO
 *
 * @author az
 * @date 2022/09/29
 * @see com.azwcl.oa.interfaces.user.vo.ImageVerificationCodeVO
 */

@Mapper
public interface ToImageVerificationCodeVoConverter {
    ToImageVerificationCodeVoConverter CONVERTER = Mappers.getMapper(ToImageVerificationCodeVoConverter.class);


    /**
     * --> ImageVerificationCodeVO
     *
     * @param codeDO ImageVerificationCodeDO
     * @return ImageVerificationCodeVO
     */
    @Mapping(target = "uid", source = "uid")
    @Mapping(target = "image", source = "image")
    ImageVerificationCodeVO toImageVerificationCodeVo(ImageVerificationCodeDO codeDO);
}
