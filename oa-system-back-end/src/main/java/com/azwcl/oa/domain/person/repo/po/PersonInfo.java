package com.azwcl.oa.domain.person.repo.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 用户信息
 *
 * @author az
 * @date 2022/09/25
 */

@Getter
@Setter
@ToString
@TableName("person_info")
public class PersonInfo {
    /**
     * id
     */
    @TableId("id")
    private Integer id;

    /**
     * 姓名
     */

    @TableField("name")
    private String name;

    /**
     * 昵称
     */
    @TableField("nickname")
    private String nickname;

    /**
     * 密码
     */
    @TableField("password")
    private String password;

    /**
     * 邮箱
     */
    @TableField("email")
    private String email;

    /**
     * 手机号
     */
    @TableField("phone")
    private String phone;

    /**
     * 性别
     */
    @TableField("sex")
    private String sex;

    /**
     * 头像
     */
    @TableField("avatar")
    private String avatar;

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

    /**
     * 修改人员
     */
    @TableField("update_person")
    private Integer updatePerson;

    /**
     * 加入日期
     */
    @TableField("join_date")
    private Integer joinDate;

    /**
     * 状态
     */
    @TableField("status")
    private Integer status;
}
