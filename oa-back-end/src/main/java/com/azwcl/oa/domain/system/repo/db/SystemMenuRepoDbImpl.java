package com.azwcl.oa.domain.system.repo.db;

import com.azwcl.oa.domain.system.repo.SystemMenuRepo;
import com.azwcl.oa.domain.system.repo.mapper.SystemMenuMapper;
import com.azwcl.oa.domain.system.repo.po.SystemMenu;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * 系统菜单 repo db 实现类
 *
 * @author az
 * @date 2022/09/20
 */

@Repository
@RequiredArgsConstructor
public class SystemMenuRepoDbImpl implements SystemMenuRepo {
    private final SystemMenuMapper systemMenuMapper;

    @Override
    public Collection<SystemMenu> findAll() {
        return systemMenuMapper.selectList(Wrappers.emptyWrapper());
    }
}
