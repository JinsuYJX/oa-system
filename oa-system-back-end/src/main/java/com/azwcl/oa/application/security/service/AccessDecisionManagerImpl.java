package com.azwcl.oa.application.security.service;

import com.azwcl.oa.infrastructure.common.enums.HttpStatus;
import com.azwcl.oa.infrastructure.exception.AssertionException;
import com.azwcl.oa.infrastructure.utils.MessageSourceUtil;
import io.jsonwebtoken.lang.Collections;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Objects;

/**
 * 权限决策
 *
 * @author az
 * @date 2022/09/25
 */
@Service
@RequiredArgsConstructor
public class AccessDecisionManagerImpl implements AccessDecisionManager {

    private final MessageSourceUtil messageSourceUtil;

    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
        if (Collections.isEmpty(configAttributes)) {
            return;
        }

        ConfigAttribute configAttribute;
        String needRole;

        for (ConfigAttribute attribute : configAttributes) {
            for (GrantedAuthority authority : authentication.getAuthorities()) {
                if (Objects.equals(attribute.getAttribute(), authority.getAuthority())) {
                    return;
                }
            }
        }

        throw new AssertionException(HttpStatus.UNAUTHORIZED, 100001, messageSourceUtil.getMessage("100001"));
    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return false;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }
}
