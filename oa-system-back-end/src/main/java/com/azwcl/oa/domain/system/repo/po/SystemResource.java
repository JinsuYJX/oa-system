package com.azwcl.oa.domain.system.repo.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 系统资源
 *
 * @author az
 * @date 2022/09/20
 */

@Getter
@Setter
@ToString
@TableName("system_resource")
public class SystemResource {
    /**
     * id
     */
    @TableId("id")
    private Integer id;

    /**
     * 资源名
     */
    @TableField("name")
    private String name;

    /**
     * 请求 url
     */
    @TableField("url")
    private String url;

    /**
     * 请求方法
     */
    @TableField("request_method")
    private String requestMethod;

    /**
     * 父资源 id
     */
    @TableField("parent_id")
    private Integer parentId;

    /**
     * 是否匿名
     */
    @TableField("is_anonymous")
    private Byte isAnonymous;

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
     * 是否默认权限
     */
    @TableField("is_default")
    private Integer isDefault;
}