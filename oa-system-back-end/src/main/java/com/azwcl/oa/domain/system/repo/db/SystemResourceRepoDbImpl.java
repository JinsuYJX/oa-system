package com.azwcl.oa.domain.system.repo.db;

import com.azwcl.oa.domain.system.entity.SystemResourceDO;
import com.azwcl.oa.domain.system.repo.SystemResourceRepo;
import com.azwcl.oa.domain.system.repo.mapper.SystemResourceMapper;
import com.azwcl.oa.domain.system.repo.po.SystemResource;
import com.azwcl.oa.infrastructure.common.enums.BooleanValue;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * 系统资源 repo db impl
 *
 * @author az
 * @date 2022/09/27
 */

@Repository
@RequiredArgsConstructor
public class SystemResourceRepoDbImpl implements SystemResourceRepo {
    private final SystemResourceMapper systemResourceMapper;

    @Override
    public Collection<SystemResourceDO> listSystemResourceDo() {
        return systemResourceMapper.listSystemResourceDo();
    }

    @Override
    public Collection<SystemResource> listDefaultResource() {
        LambdaQueryWrapper<SystemResource> queryWrapper = new LambdaQueryWrapper<SystemResource>()
                .eq(SystemResource::getIsDefault, BooleanValue.TRUE.getValueInt());

        return systemResourceMapper.selectList(queryWrapper);
    }
}
