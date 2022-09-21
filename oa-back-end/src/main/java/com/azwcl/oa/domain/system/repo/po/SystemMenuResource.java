package com.azwcl.oa.domain.system.repo.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 系统菜单资源
 *
 * @author az
 * @date 2022/09/20
 */

@Getter
@Setter
@ToString
@TableName("system_menu_resource")
public class SystemMenuResource {
    /**
     * 菜单id
     */
    @TableField("menu_id")
    private Integer menuId;

    /**
     * 资源 id
     */
    @TableField("resource_id")
    private Integer resourceId;
}
