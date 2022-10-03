package com.azwcl.oa.application.user.converter;

import com.azwcl.oa.domain.person.repo.po.PersonInfo;
import com.azwcl.oa.interfaces.user.vo.PersonInfoVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * person_info converter
 *
 * @author az
 * @date 2022/10/03
 */

@Mapper
public interface ToPersonInfoVoConverter {
    ToPersonInfoVoConverter CONVERTER = Mappers.getMapper(ToPersonInfoVoConverter.class);

    /**
     * --> PersonInfoVO
     *
     * @param info PersonInfo
     * @return PersonInfoVO
     */
    PersonInfoVO toPersonInfoVo(PersonInfo info);
}
