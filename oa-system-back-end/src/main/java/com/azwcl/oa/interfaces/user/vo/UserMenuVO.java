package com.azwcl.oa.interfaces.user.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

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

    /**
     * 添子节点
     *
     * @param menuVO 子节点集合
     */
    public void addChild(Collection<UserMenuVO> menuVO) {
        if (Objects.isNull(children)) {
            children = new ArrayList<>(menuVO);
        } else {
            children.addAll(menuVO);
        }
    }
}
