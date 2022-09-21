package com.azwcl.oa.interfaces.user.controller;

import com.azwcl.oa.application.user.service.UserLoginApplicationService;
import com.azwcl.oa.interfaces.user.vo.ImageVerificationCodeVO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录 api
 *
 * @author az
 * @date 2022/09/20
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/login")
public class LoginApi {
    private final UserLoginApplicationService loginApplicationService;

    @RequestMapping(value = "/image-code", method = RequestMethod.GET)
    public ImageVerificationCodeVO getImageVerificationCode() {
        return loginApplicationService.getLoginImageVerificationCode();
    }
}
