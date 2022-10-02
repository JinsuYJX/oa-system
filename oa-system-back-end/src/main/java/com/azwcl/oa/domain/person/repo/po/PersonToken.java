package com.azwcl.oa.domain.person.repo.po;

import com.azwcl.oa.domain.person.model.enums.LoginTypeEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 用户 token
 *
 * @author az
 * @date 2022/09/30
 */

@Getter
@Setter
@ToString
public class PersonToken {
    /**
     * token
     */
    private String token;

    /**
     * 用户 id
     */
    private Integer personId;

    /**
     * 登录类型
     */
    private LoginTypeEnum loginType;

    /**
     * 登录时间
     */
    private Long time;
}
