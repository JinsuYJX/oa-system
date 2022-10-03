package com.azwcl.oa.domain.person.service;

import com.azwcl.oa.domain.person.entity.UserRolesDO;
import com.azwcl.oa.domain.person.model.enums.LoginTypeEnum;
import com.azwcl.oa.domain.person.repo.PersonInfoRepo;
import com.azwcl.oa.domain.person.repo.PersonRoleRepo;
import com.azwcl.oa.domain.person.repo.PersonTokenRepo;
import com.azwcl.oa.domain.person.repo.po.PersonInfo;
import com.azwcl.oa.domain.person.repo.po.PersonToken;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 人员信息 service
 *
 * @author az
 * @date 2022/10/03
 */

@Service
@RequiredArgsConstructor
public class PersonInfoService {
    private final PersonInfoRepo personInfoRepo;

    @Resource(name = "PersonRoleRepoRedisImpl")
    private PersonRoleRepo personRoleRedisRepo;

    @Resource(name = "PersonRoleRepoDbImpl")
    private PersonRoleRepo personRoleDbRepo;

    private final PersonTokenRepo personTokenRepo;

    /**
     * 获取人员信息
     *
     * @param id 人员 id
     * @return 人员信息
     */
    public PersonInfo getPersonInfo(Number id) {
        return personInfoRepo.getById(id);
    }

    /**
     * 加载用户角色进入缓存
     *
     * @param id 用户id
     */
    public void loadUserRoles(Number id) {
        UserRolesDO userRoles = personRoleDbRepo.getUserRoleDoByPersonId(id);
        personRoleRedisRepo.saveUserRolesDo(userRoles);
    }

    /**
     * 生成用户 token
     *
     * @param personId      用户 id
     * @param loginTypeEnum 登录类型
     * @return 用户 token
     */

    public PersonToken generatePersonToken(Integer personId, LoginTypeEnum loginTypeEnum) {
        PersonToken token = new PersonToken(personId, loginTypeEnum);
        this.personTokenRepo.save(token);
        return token;
    }
}
