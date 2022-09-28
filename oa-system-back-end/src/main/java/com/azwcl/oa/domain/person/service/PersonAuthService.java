package com.azwcl.oa.domain.person.service;

import com.azwcl.oa.domain.person.converter.ToUserDetailsDoConverter;
import com.azwcl.oa.domain.person.entity.UserDetailsDO;
import com.azwcl.oa.domain.person.repo.PersonAuthRepo;
import com.azwcl.oa.domain.person.repo.po.PersonAuth;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


/**
 * 人员认证 service
 *
 * @author az
 * @date 2022/09/28
 */

@Service
@RequiredArgsConstructor
public class PersonAuthService {
    private final PersonAuthRepo personAuthRepo;

    /**
     * 获取人员的详细
     *
     * @param username 用户名
     * @return 人员认证信息
     */
    public UserDetailsDO getUserDetails(String username) {
        PersonAuth user = personAuthRepo.findByUsername(username);
        return ToUserDetailsDoConverter.CONVERTER.toUserDetailsDo(user);
    }
}
