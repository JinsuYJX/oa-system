package com.azwcl.oa.application.security.service;

import com.azwcl.oa.application.security.model.CustomRequestWrapper;
import com.azwcl.oa.domain.person.service.PersonAuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;
import java.util.Objects;

/**
 * 认证 过滤器
 *
 * @author az
 * @date 2022/09/30
 */

@Slf4j
@Component
@RequiredArgsConstructor
public class AuthenticationFilter implements Filter {
    private final PersonAuthService personAuthService;


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 判断是否是匿名接口
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        CustomRequestWrapper requestWrapper = new CustomRequestWrapper(request);

        // 获取 token
        String token = requestWrapper.getHeader("token");
        if (Objects.isNull(token)) {
            requestWrapper.addHeader("id", "-1");
            filterChain.doFilter(requestWrapper, servletResponse);
        } else {
            Integer personId = personAuthService.getPersonIdByToken(token);
            requestWrapper.addHeader("id", String.valueOf(personId));
            filterChain.doFilter(requestWrapper, servletResponse);
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }

    private void addHeader(HttpServletRequest request, String key, String val) {
        HttpServletRequestWrapper wrapper = new HttpServletRequestWrapper(request);

    }
}
