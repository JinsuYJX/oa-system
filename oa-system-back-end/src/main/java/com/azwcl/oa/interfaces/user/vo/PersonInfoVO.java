package com.azwcl.oa.interfaces.user.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 用户信息 vo
 *
 * @author az
 * @date 2022/10/02
 */

@Getter
@Setter
@ToString
public class PersonInfoVO {
    /**
     * id
     */
    private Integer id;

    /**
     * 姓名
     */

    private String name;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 性别
     */
    private String sex;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 创建日期
     */
    private Integer createDate;

    /**
     * 创建时间
     */
    private Integer createTime;

    /**
     * 修改日期
     */
    private Integer updateDate;

    /**
     * 修改时间
     */
    private Integer updateTime;

    /**
     * 加入日期
     */
    private Integer joinDate;

    /**
     * 状态
     */
    private Integer status;
}
