package com.azwcl.oa.domain.user.repo.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * person_info 表 po 类
 *
 * @author az
 * @date 2022/09/18
 */

@Getter
@Setter
@ToString
@TableName("PRSN_INFO")
public class PersonInfoPO {
    /**
     * id
     */
    @TableId("ID")
    private Integer id;

    /**
     * 姓名
     */
    @TableField("NAME")
    private String name;

    /**
     * 昵称
     */
    @TableField("NINA")
    private String nickname;

    /**
     * 密码
     */
    @TableField("PWD")
    private String password;

    /**
     * 邮箱
     */
    @TableField("MAIL")
    private String email;

    /**
     * 手机号
     */
    @TableField("PHOE")
    private String phone;

    /**
     * 性别
     */
    @TableField("SEX")
    private String sex;

    /**
     * 头像
     */
    @TableField("AVAR")
    private String avatar;

    /**
     * 创建日期
     */
    @TableField("CRT_DATE")
    private Integer createDate;

    /**
     * 创建时间
     */
    @TableField("CRT_TIME")
    private Integer createTime;

    /**
     * 修改日期
     */
    @TableField("UPD_DATE")
    private Integer updateDate;

    /**
     * 修改时间
     */
    @TableField("UPD_TIME")
    private Integer updateTime;

    /**
     * 修改人员
     */
    @TableField("UPD_PRSN")
    private Integer updatePerson;

    /**
     * 加入日期
     */
    @TableField("JOIN_DATE")
    private Integer joinDate;

    /**
     * 状态
     */
    @TableField("STAT")
    private Integer status;
}
