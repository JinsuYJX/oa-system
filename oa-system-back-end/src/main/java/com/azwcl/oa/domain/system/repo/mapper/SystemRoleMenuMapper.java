package com.azwcl.oa.domain.system.repo.mapper;

import com.azwcl.oa.domain.system.repo.po.SystemRoleMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;

/**
 * system_role_menu mapper
 *
 * @author az
 * @date 2022/10/05
 */

@Mapper
public interface SystemRoleMenuMapper extends BaseMapper<SystemRoleMenu> {
    /**
     * 保存所有
     *
     * @param list 一批数据
     */
    void saveAll(@Param("list") Collection<SystemRoleMenu> list);
}
