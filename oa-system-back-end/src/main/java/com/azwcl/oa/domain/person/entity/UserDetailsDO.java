package com.azwcl.oa.domain.person.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * user details domain object
 *
 * @author az
 * @date 2022/09/28
 */

@Getter
@Setter
@ToString
public class UserDetailsDO {

    /**
     * 人员 id
     */
    private Integer personId;

    /**
     * username
     */
    private String username;

    /**
     * password
     */
    private String password;
}
