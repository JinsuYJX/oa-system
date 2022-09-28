package com.azwcl.oa.application.security.service;

import com.azwcl.oa.domain.system.entity.SystemResourceDO;
import com.azwcl.oa.domain.system.service.SystemResourceService;
import com.azwcl.oa.infrastructure.common.enums.BooleanValue;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 权限资源过滤器
 *
 * @author az
 * @date 2022/09/25
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class FilterInvocationSecurityMetadataSourceImpl implements FilterInvocationSecurityMetadataSource {
    private final SystemResourceService systemResourceService;

    /**
     * 所有的资源  key : url, value : 系统资源列表
     */
    private Map<String, Collection<SystemResourceDO>> resources = null;

    @PostConstruct
    public void loadResources() {
        Collection<SystemResourceDO> allSystemResource = systemResourceService.getAllSystemResource();
        resources = new HashMap<>(allSystemResource.size());
        for (SystemResourceDO each : allSystemResource) {
            Collection<SystemResourceDO> eachResources = resources.getOrDefault(each.getUrl(), new ArrayList<>());
            eachResources.add(each);
            resources.put(each.getUrl(), eachResources);
        }
    }


    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        FilterInvocation fi = (FilterInvocation) object;
        String method = fi.getRequest().getMethod();
        String url = fi.getRequest().getRequestURI();

        AntPathMatcher matcher = new AntPathMatcher();

        // 匹配 url
        for (Map.Entry<String, Collection<SystemResourceDO>> entry : resources.entrySet()) {
            String key = entry.getKey();
            Collection<SystemResourceDO> value = entry.getValue();
            if (matcher.match(key, url)) {
                for (SystemResourceDO each : value) {
                    // url 和 method 均匹配过
                    if (Objects.equals(each.getRequestMethod(), method)) {
                        // 匿名接口返回 null
                        if(each.getIsAnonymous().equals(BooleanValue.TRUE.getValueInt())) {
                            return null;
                        }

                        // 没有角色可以访问的，返回 disable
                        if(CollectionUtils.isEmpty(each.getRolesId())) {
                            return SecurityConfig.createList("disable");
                        } else {
                            // 其余返回可以访问的角色 id
                            String[] rolesId = each.getRolesId()
                                    .stream()
                                    .map(String::valueOf)
                                    .toArray(String[]::new);
                            return SecurityConfig.createList(Arrays.toString(rolesId));
                        }
                    }
                }
            }
        }

        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
