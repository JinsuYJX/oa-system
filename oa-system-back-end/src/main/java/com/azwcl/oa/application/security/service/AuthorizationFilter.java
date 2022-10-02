package com.azwcl.oa.application.security.service;

import com.azwcl.oa.application.security.model.CustomRequestWrapper;
import com.azwcl.oa.domain.person.service.PersonAuthService;
import com.azwcl.oa.domain.system.service.SystemResourceService;
import com.azwcl.oa.infrastructure.common.enums.HttpStatus;
import com.azwcl.oa.infrastructure.common.model.FailureResponseBody;
import com.azwcl.oa.infrastructure.utils.JsonSerialize;
import com.azwcl.oa.infrastructure.utils.MessageSourceUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * 授权过滤器
 *
 * @author az
 * @date 2022/10/02
 */

@Component
@RequiredArgsConstructor
public class AuthorizationFilter implements Filter {

    private final SystemResourceService systemResourceService;

    private final PersonAuthService personAuthService;

    private final MessageSourceUtil messageSourceUtil;

    private final JsonSerialize jsonSerialize;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        // 获取 id
        CustomRequestWrapper request = (CustomRequestWrapper) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        Integer id = Integer.valueOf(request.getHeader("id"));
        // 获取该url能够访问 roles
        Collection<Integer> roles = systemResourceService.getHavePermissionRoles(request.getMethod(), request.getRequestURI());
        if (Objects.isNull(roles)) {
            // 匿名
            filterChain.doFilter(servletRequest, servletResponse);
        }

        // 获取该 id 有的角色
        List<Integer> loginPersonRoles = personAuthService.getLoginPersonRolesByPersonId(id);
        if (Objects.isNull(loginPersonRoles)) {
            response.setStatus(HttpStatus.UNAUTHORIZED.getHttpStatus());
            response.getOutputStream().write(jsonSerialize.getJson(new FailureResponseBody(100001, messageSourceUtil.getMessage("100001"))).getBytes());
            return;
        }

        for (Integer loginPersonRole : loginPersonRoles) {
            if (roles.contains(loginPersonRole)) {
                filterChain.doFilter(servletRequest, servletResponse);
            }
        }
        // 无权限
        response.setStatus(HttpStatus.UNAUTHORIZED.getHttpStatus());
        response.getOutputStream().write(jsonSerialize.getJson(new FailureResponseBody(100001, messageSourceUtil.getMessage("100001"))).getBytes());
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }

}
