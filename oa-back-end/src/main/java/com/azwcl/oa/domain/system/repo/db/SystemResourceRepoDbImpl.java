package com.azwcl.oa.domain.system.repo.db;

import com.azwcl.oa.domain.system.repo.SystemResourceRepo;
import com.azwcl.oa.domain.system.repo.mapper.SystemResourceMapper;
import com.azwcl.oa.domain.system.repo.po.SystemResource;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

/**
 * 系统资源 repo db 实现类
 *
 * @author az
 * @date 2022/09/20
 */
@Repository
@RequiredArgsConstructor
public class SystemResourceRepoDbImpl implements SystemResourceRepo {
    private final SystemResourceMapper systemResourceMapper;

    @Override
    public Collection<SystemResource> findAll() {
       return systemResourceMapper.selectList(Wrappers.emptyWrapper());
    }
}
