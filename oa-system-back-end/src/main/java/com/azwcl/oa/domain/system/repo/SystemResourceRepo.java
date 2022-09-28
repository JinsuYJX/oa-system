package com.azwcl.oa.domain.system.repo;

import com.azwcl.oa.domain.system.entity.SystemResourceDO;
import com.azwcl.oa.domain.system.repo.po.SystemResource;
import com.azwcl.oa.infrastructure.repo.BaseRepo;

import java.util.Collection;

/**
 * 系统资源 repo
 *
 * @author az
 * @date 2022/09/27
 */

public interface SystemResourceRepo extends BaseRepo<SystemResource> {

    /**
     * 获取系统资源
     *
     * @see SystemResourceDO
     * @return 全部系统资源
     */
    Collection<SystemResourceDO> listSystemResourceDo();
}
