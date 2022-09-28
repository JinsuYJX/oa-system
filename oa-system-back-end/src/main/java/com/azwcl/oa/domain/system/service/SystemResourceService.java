package com.azwcl.oa.domain.system.service;

import com.azwcl.oa.domain.system.entity.SystemResourceDO;
import com.azwcl.oa.domain.system.repo.SystemResourceRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * 系统资源 service
 *
 * @author az
 * @date 2022/09/28
 */

@Service
@RequiredArgsConstructor
public class SystemResourceService {
    private final SystemResourceRepo systemResourceRepo;

    /**
     * 获取所有系统资源
     *
     * @return 系统资源
     */
    public Collection<SystemResourceDO> getAllSystemResource() {
        return systemResourceRepo.listSystemResourceDo();
    }
}
