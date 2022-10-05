package com.azwcl.oa.domain.system.repo.mapper;

import com.azwcl.oa.domain.system.repo.po.SystemMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;

/**
 * system_menu mapper
 *
 * @author az
 * @date 2022/10/04
 */

@Mapper
public interface SystemMenuMapper extends BaseMapper<SystemMenu> {
    /**
     * 通过角色id获取下面的系统菜单
     *
     * @param roleIds 角色 id
     * @return 系统菜单
     */
    Collection<SystemMenu> getByRoleId(@Param("roles") Collection<Integer> roleIds);
}
