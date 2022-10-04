package com.azwcl.oa.domain.system.repo.po;

import com.baomidou.mybatisplus.annotation.TableField;

/**
 * system_role_menu
 *
 * @author az
 * @date 2022/10/04
 */

public class SystemRoleMenu {

    /**
     * 角色id
     */
    @TableField("role_id")
    private Integer roleId;

    /**
     * 菜单id
     */
    @TableField("menu_id")
    private Integer menuId;

    /**
     * 是否只读
     */
    @TableField("is_only_read")
    private Integer isOnlyRead;
}
