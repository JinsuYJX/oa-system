package com.azwcl.oa.interfaces.user.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 用户详细 VO
 *
 * @author az
 * @date 2022/09/30
 */

@Getter
@Setter
@ToString
@AllArgsConstructor
public class UserDetailsVO {
    /**
     * token
     */
    private String token;


    /**
     * 人员信息 vo
     */
    private PersonInfoVO info;
}
