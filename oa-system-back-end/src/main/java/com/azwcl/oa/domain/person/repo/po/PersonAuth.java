package com.azwcl.oa.domain.person.repo.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * person_auth table
 *
 * @author az
 * @date 2022/09/28
 */

@Getter
@Setter
@ToString
@TableName("person_auth")
public class PersonAuth {

    /**
     * 人员 id
     */
    @TableField("person_id")
    private Integer personId;

    /**
     * 登录的 username
     */
    @TableField("username")
    private String username;

    /**
     * 登录的 password
     */
    @TableField("password")
    private String password;

    /**
     * 登录类型
     */
    @TableField("login_type")
    private Integer loginType;

    /**
     * 创建日期
     */
    @TableField("create_date")
    private Integer createDate;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Integer createTime;

    /**
     * 修改日期
     */
    @TableField("update_date")
    private Integer updateDate;

    /**
     * 修改时间
     */
    @TableField("update_time")
    private Integer updateTime;
}
