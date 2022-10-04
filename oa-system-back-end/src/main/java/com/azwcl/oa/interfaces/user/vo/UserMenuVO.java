package com.azwcl.oa.interfaces.user.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * 用户菜单 vo
 *
 * @author az
 * @date 2022/10/04
 */

@Getter
@Setter
@ToString
public class UserMenuVO {
    /**
     * 菜单id
     */
    private Integer id;

    /**
     * 菜单名
     */
    private String name;

    /**
     * 前端路径
     */
    private String path;

    /**
     * 前端组件
     */
    private String component;

    /**
     * 前端 icon
     */
    private String icon;

    /**
     * 父级菜单 id
     */
    private Integer parentId;

    /**
     * 子菜单
     */
    private List<UserMenuVO> children;
}
