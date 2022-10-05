package com.azwcl.oa.domain.system.repo.db;

import com.azwcl.oa.domain.system.repo.SystemRoleRepo;
import com.azwcl.oa.domain.system.repo.mapper.SystemRoleMapper;
import com.azwcl.oa.domain.system.repo.po.SystemRole;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * system_role repo db impl
 *
 * @author az
 * @date 2022/10/04
 */

@Repository
@RequiredArgsConstructor
public class SystemRoleRepoDbImpl implements SystemRoleRepo {
    private final SystemRoleMapper systemRoleMapper;
    @Override
    public void save(SystemRole systemRole) {
        systemRoleMapper.insert(systemRole);
    }
}
