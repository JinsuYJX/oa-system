package com.azwcl.oa.domain.system.repo.mapper;

import com.azwcl.oa.domain.system.entity.SystemRoleDO;
import com.azwcl.oa.domain.system.repo.po.SystemRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


/**
 * system_role mapper
 *
 * @author az
 * @date 2022/10/04
 */

@Mapper
public interface SystemRoleMapper extends BaseMapper<SystemRole> {

    /**
     * 查询系统角色 DO
     *
     * @param page      分页器
     * @param searchKey 搜索词
     * @return 返回
     */
    IPage<SystemRoleDO> querySystemRoleDO(Page<SystemRole> page, @Param("searchKey") String searchKey);
}
