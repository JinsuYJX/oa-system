package com.azwcl.oa.domain.user.repo.mapper;

import com.azwcl.oa.domain.user.repo.po.PersonInfoPO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * person_info 表 mapper
 *
 * @author az
 * @date 2022/09/18
 */

@Mapper
public interface PersonInfoMapper extends BaseMapper<PersonInfoPO> {
}
