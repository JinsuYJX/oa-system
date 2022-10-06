package com.azwcl.oa.domain.person.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * 用户角色
 *
 * @author az
 * @date 2022/10/02
 */

@Setter
@Getter

@ToString
@AllArgsConstructor
public class UserRolesDO {
    /**
     * 用户 id
     */
    private Integer personId;

    /**
     * 对应角色
     */
    private List<Integer> roles;
}
