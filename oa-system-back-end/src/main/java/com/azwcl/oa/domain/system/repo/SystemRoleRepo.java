package com.azwcl.oa.domain.system.repo;

import com.azwcl.oa.domain.system.entity.SystemRoleDO;
import com.azwcl.oa.domain.system.repo.po.SystemRole;
import com.azwcl.oa.infrastructure.common.model.BaseQuery;
import com.azwcl.oa.infrastructure.common.model.Paging;
import com.azwcl.oa.infrastructure.repo.BaseRepo;

/**
 * system_role repo
 *
 * @author az
 * @date 2022/10/04
 */

public interface SystemRoleRepo extends BaseRepo<SystemRole> {
    /**
     * 查询系统角色 do
     *
     * @param query 查询器
     * @return 返回系统角色
     */
    Paging<SystemRoleDO> querySystemRoleDO(BaseQuery query);
}
