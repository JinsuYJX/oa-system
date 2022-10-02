package com.azwcl.oa.infrastructure.config;

import com.azwcl.oa.application.security.service.AuthenticationFilter;
import com.azwcl.oa.application.security.service.AuthorizationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 过滤器 config
 *
 * @author az
 * @date 2022/10/02
 */

@Configuration
@RequiredArgsConstructor
public class FilterConfig {
    private final AuthenticationFilter authenticationFilter;
    private final AuthorizationFilter authorizationFilter;

    @Bean
    public FilterRegistrationBean<AuthenticationFilter> authenticationFilterFilterRegistrationBean() {
        FilterRegistrationBean<AuthenticationFilter> bean = new FilterRegistrationBean<>();
        bean.setFilter(authenticationFilter);
        bean.setOrder(1);
        return bean;
    }

    @Bean
    public FilterRegistrationBean<AuthorizationFilter> authorizationFilterFilterRegistrationBean() {
        FilterRegistrationBean<AuthorizationFilter> bean = new FilterRegistrationBean<>();
        bean.setFilter(authorizationFilter);
        bean.setOrder(2);
        return bean;
    }
}
