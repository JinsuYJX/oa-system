package com.azwcl.oa.domain.system.repo.db;

import com.azwcl.oa.domain.system.entity.SystemRoleDO;
import com.azwcl.oa.domain.system.repo.SystemRoleRepo;
import com.azwcl.oa.domain.system.repo.mapper.SystemRoleMapper;
import com.azwcl.oa.domain.system.repo.po.SystemRole;
import com.azwcl.oa.infrastructure.common.model.BaseQuery;
import com.azwcl.oa.infrastructure.common.model.Paging;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;
import io.jsonwebtoken.lang.Collections;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

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
        if (Collections.isEmpty(ids)) {
            return;
        }

        List<List<Number>> partition = Lists.partition(Lists.newArrayList(ids), DEFAULT_BATCH_SIZE);
        for (List<Number> each : partition) {
            LambdaQueryWrapper<SystemRole> queryWrapper = new LambdaQueryWrapper<SystemRole>()
                    .in(SystemRole::getId, ids);
            systemRoleMapper.delete(queryWrapper);
        }
    }

    @Override
    public void updateById(SystemRole role) {
        if (Objects.isNull(role.getId())) {
            return;
        }
        systemRoleMapper.updateById(role);
    }

    /**
     * 查询系统角色 do
     *
     * @param query 查询器
     * @return 返回系统角色
     */
    @Override
    public Paging<SystemRoleDO> querySystemRoleDO(BaseQuery query) {
        Page<SystemRole> page = new Page<>(query.getPageNumber(), query.getPageSize());
        IPage<SystemRoleDO> res = systemRoleMapper.querySystemRoleDO(page, query.getSearchKey());

        return new Paging<>(query, res.getTotal(), res.getRecords());
    }
}
