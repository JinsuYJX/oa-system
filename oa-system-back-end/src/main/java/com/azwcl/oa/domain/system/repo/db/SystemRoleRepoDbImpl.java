package com.azwcl.oa.domain.system.repo.db;

import com.azwcl.oa.domain.system.repo.SystemRoleRepo;
import com.azwcl.oa.domain.system.repo.mapper.SystemRoleMapper;
import com.azwcl.oa.domain.system.repo.po.SystemRole;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.google.common.collect.Lists;
import io.jsonwebtoken.lang.Collections;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

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

    @Override
    public void deleteById(Number id) {
        systemRoleMapper.deleteById(id);
    }

    @Override
    public void deleteByIds(Collection<Number> ids) {
        if(Collections.isEmpty(ids)) {
            return  ;
        }

        List<List<Number>> partition = Lists.partition(Lists.newArrayList(ids), DEFAULT_BATCH_SIZE);
        for (List<Number> each : partition) {
            LambdaQueryWrapper<SystemRole> queryWrapper = new LambdaQueryWrapper<SystemRole>()
                    .in(SystemRole::getId, ids);
            systemRoleMapper.delete(queryWrapper);
        }
    }
}
