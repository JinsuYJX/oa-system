package com.azwcl.oa.domain.person.service;

import com.azwcl.oa.domain.person.converter.ToUserDetailsDoConverter;
import com.azwcl.oa.domain.person.entity.UserDetailsDO;
import com.azwcl.oa.domain.person.entity.UserRolesDO;
import com.azwcl.oa.domain.person.repo.PersonAuthRepo;
import com.azwcl.oa.domain.person.repo.PersonRoleRepo;
import com.azwcl.oa.domain.person.repo.PersonTokenRepo;
import com.azwcl.oa.domain.person.repo.po.PersonAuth;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;


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

    private final PersonTokenRepo personTokenRepo;

    @Resource(name = "PersonRoleRepoDbImpl")
    private PersonRoleRepo personRoleRedisRepo;

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

    /**
     * 通过 token 获取用户 id
     *
     * @param token 用户登录的 token
     * @return 用户 id
     */

    public Integer getPersonIdByToken(String token) {
        if (token == null) {
            return null;
        }
        return personTokenRepo.getPersonIdByToken(token);
    }

    /**
     * 通过人员 id 获取登录人员角色
     *
     * @param id 人员 id
     * @return 角色
     */
    public List<Integer> getLoginPersonRolesByPersonId(Integer id) {
        UserRolesDO alreadyLoginPersonRolesByPersonId = personRoleRedisRepo.getAlreadyLoginPersonRolesByPersonId(id);
        if (Objects.isNull(alreadyLoginPersonRolesByPersonId)) {
            return null;
        } else {
            return alreadyLoginPersonRolesByPersonId.getRoles();
        }
    }
}
