package com.azwcl.oa.domain.system.repo.db;

import com.azwcl.oa.domain.system.repo.SystemMenuRepo;
import com.azwcl.oa.domain.system.repo.mapper.SystemMenuMapper;
import com.azwcl.oa.domain.system.repo.po.SystemMenu;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Collections;

/**
 * system_menu repo db impl
 *
 * @author az
 * @date 2022/10/04
 */

@Repository
@RequiredArgsConstructor
public class SystemMenuRepoDbImpl implements SystemMenuRepo {
    private final SystemMenuMapper systemMenuMapper;

    @Override
    public Collection<SystemMenu> getRoleMenu(Collection<Integer> roleId) {
        if (CollectionUtils.isEmpty(roleId)) {
            return Collections.emptyList();
        }
        return systemMenuMapper.getByRoleId(roleId);
    }
}
