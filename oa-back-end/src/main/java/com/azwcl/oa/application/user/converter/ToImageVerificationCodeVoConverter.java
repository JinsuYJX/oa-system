package com.azwcl.oa.application.user.converter;

import com.azwcl.oa.domain.code.entity.domainobject.ImageVerificationCodeDO;
import com.azwcl.oa.interfaces.user.vo.ImageVerificationCodeVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * 转换图片验证码 vo
 *
 * @author az
 * @date 2022/09/20
 */

@Mapper
public interface ToImageVerificationCodeVoConverter {
    ToImageVerificationCodeVoConverter CONVERTER = Mappers.getMapper(ToImageVerificationCodeVoConverter.class);

    /**
     * --> ImageVerificationCodeVO
     *
     * @param code ImageVerificationCodeDO
     * @return ImageVerificationCodeVO
     */
    @Mapping(target = "uid", source = "uid")
    @Mapping(target = "image", source = "image")
    ImageVerificationCodeVO toImageVerificationCodeVo(ImageVerificationCodeDO code);

}
