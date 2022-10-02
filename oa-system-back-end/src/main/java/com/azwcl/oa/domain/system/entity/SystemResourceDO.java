package com.azwcl.oa.domain.system.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * 系统资源 domain object
 *
 * @author az
 * @date 2022/09/27
 */

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class SystemResourceDO {

    /**
     * 资源 Id
     */
    private Integer id;

    /**
     * 资源 url
     */
    private String url;

    /**
     * 请求方式
     */
    private String requestMethod;

    /**
     * 是否是匿名
     */
    private Integer isAnonymous;

    /**
     * 可访问角色 id 集合
     */
    private List<Integer> rolesId;
    
    /**
     * 判断 角色id 是否有权限
     *
     * @param roleId 角色 id
     * @return true - 有；false - 无
     */
    public boolean isHavePermission(Integer roleId) {
        return rolesId.contains(roleId);
    }
}
