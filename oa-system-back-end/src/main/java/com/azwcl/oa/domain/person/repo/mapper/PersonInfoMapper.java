package com.azwcl.oa.domain.person.repo.mapper;

import com.azwcl.oa.domain.person.repo.po.PersonInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * person_info mapper
 *
 * @author az
 * @date 2022/10/03
 */

@Mapper
public interface PersonInfoMapper extends BaseMapper<PersonInfo> {
}
