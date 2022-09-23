package com.azwcl.oa.interfaces.user.controller;

import com.azwcl.oa.application.user.service.UserLoginApplicationService;
import com.azwcl.oa.interfaces.user.dto.VerificationCodeDTO;
import com.azwcl.oa.interfaces.user.vo.ImageVerificationCodeVO;
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
 * @date 2022/09/20
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/login")
public class LoginApi {
    private final UserLoginApplicationService loginApplicationService;

    @RequestMapping(value = "/code/image", method = RequestMethod.GET)
    public ImageVerificationCodeVO getImageVerificationCode() {
        return loginApplicationService.getLoginImageVerificationCode();
    }

    @RequestMapping(value = "/code", method = RequestMethod.POST)
    public void getCode(@RequestBody VerificationCodeDTO codeDto) {
        loginApplicationService.sendLoginVerificationCode(codeDto);
    }
}
