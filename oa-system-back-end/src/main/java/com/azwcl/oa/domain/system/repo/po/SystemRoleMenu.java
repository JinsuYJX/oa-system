package com.azwcl.oa.domain.system.repo.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * system_role_menu
 *
 * @author az
 * @date 2022/10/04
 */

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@TableName("system_role_menu")
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
