package com.azwcl.oa.domain.person.repo.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 用户角色
 *
 * @author az
 * @date 2022/10/02
 */

@Getter
@Setter
@ToString
@TableName("person_role")
public class PersonRole {
    /**
     * 人员 id
     */
    @TableField("person_id")
    private Integer personId;

    /**
     * 角色 id
     */
    @TableField("role_id")
    private Integer roleId;
}
