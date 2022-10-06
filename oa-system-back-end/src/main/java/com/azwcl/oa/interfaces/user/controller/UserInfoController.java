package com.azwcl.oa.interfaces.user.controller;

import com.azwcl.oa.application.user.service.UserInfoApplicationService;
import com.azwcl.oa.interfaces.user.vo.UserMenuVO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * 用户信息 controller
 *
 * @author az
 * @date 2022/10/03
 */

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/user")
public class UserInfoController {
    private final UserInfoApplicationService userInfoApplicationService;

    /**
     * 获取用户自己的菜单
     *
     * @param userId 用户id
     * @return 返回数据
     */
    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    public Collection<UserMenuVO> getUserSelfMenu(@RequestHeader("id") Integer userId) {
        return userInfoApplicationService.getUserMenu(userId);
    }
}
