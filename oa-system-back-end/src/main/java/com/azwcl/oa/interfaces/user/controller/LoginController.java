package com.azwcl.oa.interfaces.user.controller;

import com.azwcl.oa.application.user.service.LoginApplicationService;
import com.azwcl.oa.infrastructure.exception.AssertionException;
import com.azwcl.oa.infrastructure.utils.MessageSourceUtil;
import com.azwcl.oa.interfaces.user.command.LoginCommand;
import com.azwcl.oa.interfaces.user.vo.ImageVerificationCodeVO;
import com.azwcl.oa.interfaces.user.vo.UserDetailsVO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * 登录 api
 *
 * @author az
 * @date 2022/09/28
 */

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/login")
public class LoginController {
    private final LoginApplicationService loginApplicationService;

    private final MessageSourceUtil messageSourceUtil;

    /**
     * 图片验证码获取
     *
     * @return 图片验证码
     */
    @RequestMapping(value = "/code/image", method = RequestMethod.GET)
    public ImageVerificationCodeVO getLoginImageVerificationCode() {
        return loginApplicationService.getLoginImageVerificationCode();
    }

    /**
     * 通过密码登录
     *
     * @param command 登录 command
     * @return 用户详细信息
     */
    @RequestMapping(value = "/password", method = RequestMethod.POST)
    public UserDetailsVO loginByPassword(@RequestBody LoginCommand command) {
        if (Objects.isNull(command.getUsername()) || Objects.isNull(command.getPassword()) || Objects.isNull(command.getUid()) || Objects.isNull(command.getCode())) {
            throw new AssertionException(100005, messageSourceUtil.getMessage("100005"));
        }

        return loginApplicationService.loginByPassword(command);
    }
}
