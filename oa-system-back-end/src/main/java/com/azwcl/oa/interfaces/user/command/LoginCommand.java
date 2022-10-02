package com.azwcl.oa.interfaces.user.command;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 登录 command
 *
 * @author az
 * @date 2022/09/30
 */

@Getter
@Setter
@ToString
public class LoginCommand {

    /**
     * 登录username
     */
    private String username;

    /**
     * 登录 password
     */
    private String password;

    /**
     * 图片 uid
     */
    private String uid;

    /**
     * 图片 code
     */
    private String code;
}
