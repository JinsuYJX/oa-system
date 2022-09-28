package com.azwcl.oa.domain.system.repo.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 系统角色资源
 *
 * @author az
 * @date 2022/09/25
 */

@Getter
@Setter
@ToString
@TableName("system_role_resource")
public class SystemRoleResource {
    /**
     * 角色 id
     */
    @TableField("role_id")
    private Integer roleId;

    /**
     * 资源 id
     */
    @TableField("resource_id")
    private Integer resourceId;
}
