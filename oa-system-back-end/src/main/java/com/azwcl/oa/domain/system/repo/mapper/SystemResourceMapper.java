package com.azwcl.oa.domain.system.repo.mapper;

import com.azwcl.oa.domain.system.entity.SystemResourceDO;
import com.azwcl.oa.domain.system.repo.po.SystemResource;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.Collection;

/**
 * system resource mapper
 *
 * @author az
 * @date 2022/09/27
 */

@Mapper
public interface SystemResourceMapper extends BaseMapper<SystemResource> {
    /**
     * 获取系统资源
     *
     * @see SystemResourceDO
     *
     * @return 全部系统资源
     */
    Collection<SystemResourceDO> listSystemResourceDo();
}
