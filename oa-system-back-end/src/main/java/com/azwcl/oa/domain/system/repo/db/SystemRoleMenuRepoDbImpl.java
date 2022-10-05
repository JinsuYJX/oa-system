package com.azwcl.oa.domain.system.repo.db;

import com.azwcl.oa.domain.system.repo.SystemRoleMenuRepo;
import com.azwcl.oa.domain.system.repo.mapper.SystemRoleMenuMapper;
import com.azwcl.oa.domain.system.repo.po.SystemRoleMenu;
import com.google.common.collect.Lists;
import io.jsonwebtoken.lang.Collections;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

/**
 * system_role_menu repo db impl
 *
 * @author az
 * @date 2022/10/05
 */

@Repository
@RequiredArgsConstructor
public class SystemRoleMenuRepoDbImpl implements SystemRoleMenuRepo {
    private final SystemRoleMenuMapper systemRoleMenuMapper;

    @Override
    public void saveAll(Collection<SystemRoleMenu> list) {
        if (Collections.isEmpty(list)) {
            return;
        }

        List<List<SystemRoleMenu>> partition = Lists.partition(Lists.newArrayList(list), DEFAULT_BATCH_SIZE);

        for (List<SystemRoleMenu> eachRoleMenus : partition) {
            systemRoleMenuMapper.saveAll(eachRoleMenus);
        }
    }
}
