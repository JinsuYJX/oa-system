package com.azwcl.oa.interfaces.permission.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 角色 vo
 *
 * @author az
 * @date 2022/10/06
 */

@Getter
@Setter
@ToString
public class RoleVO {

    /**
     * id
     */
    private Integer id;

    /**
     * 角色名
     */
    private String name;

    /**
     * 角色描述
     */
    private String describe;

    /**
     * 创建日期
     */
    private Integer createDate;

    /**
     * 创建时间
     */
    private Integer createTime;

    /**
     * 创建人
     */
    private String createPerson;

    /**
     * 修改日期
     */
    private Integer updateDate;

    /**
     * 修改时间
     */
    private Integer updateTime;

    /**
     * 修改人
     */
    private String updatePerson;

    /**
     * 备注
     */
    private String remark;
}
