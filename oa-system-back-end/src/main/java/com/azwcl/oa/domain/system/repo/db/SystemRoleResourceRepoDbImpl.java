package com.azwcl.oa.domain.system.repo.db;

import com.azwcl.oa.domain.system.repo.SystemRoleResourceRepo;
import com.azwcl.oa.domain.system.repo.mapper.SystemRoleResourceMapper;
import com.azwcl.oa.domain.system.repo.po.SystemRoleResource;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.google.common.collect.Lists;
import io.jsonwebtoken.lang.Collections;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

/**
 * system_role_resource repo db impl
 *
 * @author az
 * @date 2022/10/05
 */

@Repository
@RequiredArgsConstructor
public class SystemRoleResourceRepoDbImpl implements SystemRoleResourceRepo {

    private final SystemRoleResourceMapper systemRoleResourceMapper;

    @Override
    public void saveAll(Collection<SystemRoleResource> list) {
        if (Collections.isEmpty(list)) {
            return;
        }

        List<List<SystemRoleResource>> partition = Lists.partition(Lists.newArrayList(list), DEFAULT_BATCH_SIZE);

        for (List<SystemRoleResource> eachRoleResource : partition) {
            systemRoleResourceMapper.saveAll(eachRoleResource);
        }
    }

    @Override
    public void deleteByRole(Collection<Number> roles) {
        if(Collections.isEmpty(roles)) {
            return;
        }

        List<List<Number>> partition = Lists.partition(Lists.newArrayList(roles), DEFAULT_BATCH_SIZE);

        for (List<Number> each : partition) {
            LambdaQueryWrapper<SystemRoleResource> queryWrapper = new LambdaQueryWrapper<SystemRoleResource>()
                    .in(SystemRoleResource::getRoleId, each);
            systemRoleResourceMapper.delete(queryWrapper);
        }
    }
}
