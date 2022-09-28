package com.azwcl.oa.application.security.service;

import com.azwcl.oa.domain.person.entity.UserDetailsDO;
import com.azwcl.oa.domain.person.service.PersonAuthService;
import com.azwcl.oa.infrastructure.common.enums.HttpStatus;
import com.azwcl.oa.infrastructure.exception.AssertionException;
import com.azwcl.oa.infrastructure.utils.MessageSourceUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * 用户登录
 *
 * @author az
 * @date 2022/09/25
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final PersonAuthService personAuthService;

    private final MessageSourceUtil messageSourceUtil;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetailsDO user = personAuthService.getUserDetails(username);

        if(Objects.isNull(user)) {
            throw new AssertionException(HttpStatus.UNAUTHORIZED, 100000, messageSourceUtil.getMessage("100000"));
        }

        return user;
    }

}
