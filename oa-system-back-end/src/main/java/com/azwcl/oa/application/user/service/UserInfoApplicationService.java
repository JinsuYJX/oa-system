package com.azwcl.oa.application.user.service;

import com.azwcl.oa.application.user.converter.ToUserMenuVoConverter;
import com.azwcl.oa.domain.person.service.PersonInfoService;
import com.azwcl.oa.domain.system.repo.po.SystemMenu;
import com.azwcl.oa.domain.system.service.SystemMenuService;
import com.azwcl.oa.interfaces.user.vo.UserMenuVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 用户信息 application service
 *
 * @author az
 * @date 2022/10/04
 */

@Service
@RequiredArgsConstructor
public class UserInfoApplicationService {

    private final PersonInfoService personInfoService;

    private final SystemMenuService systemMenuService;

    /**
     * 获取用户菜单
     *
     * @param userId 用户 id
     * @return 用户菜单
     */
    public Collection<UserMenuVO> getUserMenu(Integer userId) {
        Collection<Integer> roles = personInfoService.getRolesIdByPersonId(userId);
        Collection<SystemMenu> roleMenu = systemMenuService.getRoleMenu(roles);

        List<UserMenuVO> userMenus = roleMenu
                .stream()
                .map(ToUserMenuVoConverter.CONVERTER::toUserMenuVo)
                .collect(Collectors.toList());

        List<UserMenuVO> returnData = new ArrayList<>(userMenus.size());

        // 组装
        for (UserMenuVO each : userMenus) {
            // 只加父节点
            if (each.getParentId().equals(-1)) {
                returnData.add(each);
            }
            // 过滤出孩子
            List<UserMenuVO> children = userMenus
                    .stream()
                    .filter(obj -> Objects.equals(obj.getParentId(), each.getId()))
                    .collect(Collectors.toList());
            // 设置
            each.addChild(children);
        }

        return returnData;
    }

}
