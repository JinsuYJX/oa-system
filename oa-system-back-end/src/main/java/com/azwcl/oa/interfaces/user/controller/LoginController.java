package com.azwcl.oa.interfaces.user.controller;

import com.azwcl.oa.application.user.service.LoginApplicationService;
import com.azwcl.oa.interfaces.user.vo.ImageVerificationCodeVO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    /**
     * 图片验证码获取
     *
     * @return 图片验证码
     */
    @RequestMapping(value = "/code/image", method = RequestMethod.GET)
    public ImageVerificationCodeVO getLoginImageVerificationCode() {
        return loginApplicationService.getLoginImageVerificationCode();
    }
}
