package com.azwcl.oa.application.security.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * todo
 *
 * @author az
 * @date 2022/09/20
 */

@Getter
@Setter
@ToString
public class ResourceRoleDTO {

    /**
     * 资源id
     */
    private Integer id;

    /**
     * 路径
     */
    private String url;

    /**
     * 请求方法
     */
    private String requestMethod;

    /**
     * 是否匿名接口
     */
    private Integer isAnonymous;

    /**
     * 角色 id
     */
    private List<Integer> role;
}
