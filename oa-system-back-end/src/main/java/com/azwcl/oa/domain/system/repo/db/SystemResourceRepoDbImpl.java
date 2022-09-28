package com.azwcl.oa.domain.system.repo.db;

import com.azwcl.oa.domain.system.entity.SystemResourceDO;
import com.azwcl.oa.domain.system.repo.SystemResourceRepo;
import com.azwcl.oa.domain.system.repo.mapper.SystemResourceMapper;
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

}
