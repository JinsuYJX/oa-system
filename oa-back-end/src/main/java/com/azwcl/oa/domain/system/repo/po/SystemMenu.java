package com.azwcl.oa.domain.system.repo.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 系统菜单
 *
 * @author az
 * @date 2022/09/20
 */
@Getter
@Setter
@ToString
@TableName("system_menu")
public class SystemMenu {
    /**
     * id
     */
    @TableId("id")
    private Integer id;

    /**
     * 菜单名
     */
    @TableField("name")
    private String name;

    /**
     * 路径
     */
    @TableField("path")
    private String path;

    /**
     * 组件
     */
    @TableField("component")
    private String component;

    /**
     * 图标
     */
    @TableField("icon")
    private String icon;

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
     * 父菜单 id
     */
    @TableField("parent_id")
    private Integer parentId;

    /**
     * 状态 102 0-正常，1-停用
     */
    @TableField("status")
    private Integer status;
}
