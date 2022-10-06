package com.azwcl.oa.interfaces.permission.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 新建角色 command
 *
 * @author az
 * @date 2022/10/04
 */
@Getter
@Setter
@ToString
public class RoleCommand {
    /**
     * id
     */
    private Integer id;

    /**
     * 角色名
     */
    private String name;

    /**
     * 描述
     */
    private String describe;

    /**
     * 备注
     */
    private String remark;
}
