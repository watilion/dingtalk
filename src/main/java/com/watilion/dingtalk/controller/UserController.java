package com.watilion.dingtalk.controller;

import com.watilion.dingtalk.entity.DingTalkUser;
import com.watilion.dingtalk.entity.Response;
import com.watilion.dingtalk.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Project: dingtalk
 * @Package: com.watilion.dingtalk.controller
 * @author: 吴腾龙
 * @Company: 浙江高速信息工程技术有限公司
 * @Created Date:	2019/12/26 10:47
 * <p>
 * <p>
 * Copyright @ 2019 www.zeiet.com – Confidential and Proprietary
 * <p>
 * 描述：
 */

@RestController
@Api(value="/user",tags="用户信息获取接口")
@RequestMapping("/sys")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/mobileByCode/{code}")
    @ApiOperation(value="根据免密登录code获取用户信息", notes ="根据免密登录code获取用户信息")
    private Response<DingTalkUser> getMobileByCode(@PathVariable String code){
        return userService.getMobileByCode(code);
    }

    @GetMapping("getDingTalkUserIdByMobile")
    @ApiOperation("根据手机号获取用户信息")
    private Response<String> getDingTalkUserIdByMobile(String mobile){
        return userService.getDingTalkUserIdByMobile(mobile);
    }


}
