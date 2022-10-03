package com.azwcl.oa.domain.system.service;

import com.azwcl.oa.domain.system.entity.SystemResourceDO;
import com.azwcl.oa.domain.system.repo.SystemResourceRepo;
import com.azwcl.oa.infrastructure.common.enums.BooleanValue;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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


    private final Map<String, Map<String, SystemResourceDO>> allSystemResources = new HashMap<>(8);

    /**
     * 获取所有系统资源
     *
     * @return 系统资源
     */
    public Collection<SystemResourceDO> getAllSystemResource() {
        return systemResourceRepo.listSystemResourceDo();
    }

    /**
     * 加载所有系统资源
     */
    @PostConstruct
    public void loadAllSystemResource() {
        Collection<SystemResourceDO> systemResourceDos = systemResourceRepo.listSystemResourceDo();

        for (SystemResourceDO eachSystemResource : systemResourceDos) {
            Map<String, SystemResourceDO> eachUrlSystemResource = allSystemResources.getOrDefault(eachSystemResource.getRequestMethod(), new HashMap<>(16));
            eachUrlSystemResource.put(eachSystemResource.getUrl(), eachSystemResource);
            allSystemResources.put(eachSystemResource.getRequestMethod(), eachUrlSystemResource);
        }
    }

    /**
     * 获取有权限访问的角色
     *
     * @param method 请求方法
     * @param url    请求url
     * @return 有权限访问的角色 null-代表匿名接口，即所有角色均可访问
     */
    public Collection<Integer> getHavePermissionRoles(String method, String url) {
        Map<String, SystemResourceDO> urlSystemResources = allSystemResources.get(method);

        AntPathMatcher matcher = new AntPathMatcher();
        for (Map.Entry<String, SystemResourceDO> entry : urlSystemResources.entrySet()) {
            String k = entry.getKey();
            SystemResourceDO v = entry.getValue();
            if (matcher.match(k, url)) {
                if(Objects.equals(v.getIsAnonymous(), BooleanValue.TRUE.getValueInt())) {
                    return null;
                }
                return v.getRolesId();
            }
        }

        return null;
    }
}
