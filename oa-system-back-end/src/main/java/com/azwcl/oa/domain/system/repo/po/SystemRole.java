package com.azwcl.oa.domain.system.repo.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 系统角色
 *
 * @author az
 * @date 2022/09/20
 */

@Getter
@Setter
@ToString
@TableName("system_role")
public class SystemRole {
    /**
     * id
     */
    @TableId(value = "`id`", type = IdType.AUTO)
    private Integer id;

    /**
     * 角色名
     */
    @TableField("`name`")
    private String name;

    /**
     * 描述
     */
    @TableField("`describe`")
    private String describe;

    /**
     * 创建日期
     */
    @TableField("`create_date`")
    private Integer createDate;

    /**
     * 创建时间
     */
    @TableField("`create_time`")
    private Integer createTime;

    /**
     * 创建人
     */
    @TableField("`create_person`")
    private Integer createPerson;

    /**
     * 修改日期
     */
    @TableField("`update_date`")
    private Integer updateDate;

    /**
     * 修改时间
     */
    @TableField("`update_time`")
    private Integer updateTime;

    /**
     * 修改人
     */
    @TableField("`update_person`")
    private Integer updatePerson;

    /**
     * 备注
     */
    @TableField("`remark`")
    private String remark;
}