package com.azwcl.oa.domain.person.service;

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

    /**
     * 认证
     *
     * @param inputAuth 输入的认证信息
     * @return 返回获取的人员认证信息
     */
    public PersonAuth getPersonAuthentication(PersonAuth inputAuth) {
        return personAuthRepo.getByUsername(inputAuth.getUsername());
    }
}
