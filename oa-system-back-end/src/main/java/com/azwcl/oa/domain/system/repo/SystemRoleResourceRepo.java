package com.azwcl.oa.domain.system.repo;

import com.azwcl.oa.domain.system.repo.po.SystemRoleResource;
import com.azwcl.oa.infrastructure.repo.BaseRepo;

import java.util.Collection;

/**
 * system_role_resource repo
 *
 * @author az
 * @date 2022/10/05
 */

public interface SystemRoleResourceRepo extends BaseRepo<SystemRoleResource> {
    /**
     * 通过角色删除
     *
     * @param roles 角色
     */
    default void deleteByRole(Collection<Number> roles) {

    }
}
