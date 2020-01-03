package com.watilion.dingtalk.controller;

import com.watilion.dingtalk.entity.Response;
import com.watilion.dingtalk.service.DingTalkMsgService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Project: dingtalk
 * @Package: com.watilion.dingtalk.controller
 * @author: 吴腾龙
 * @Company: 浙江高速信息工程技术有限公司
 * @Created Date:	2019/12/26 20:25
 * <p>
 * <p>
 * Copyright @ 2019 www.zeiet.com – Confidential and Proprietary
 * <p>
 * 描述：
 */

@RestController
@Api(value="/send",tags="用户信息获取接口")
@RequestMapping("/dingTalkMsg")
public class DingTalkMsgController {

    private final DingTalkMsgService dingTalkMsgService;

    public DingTalkMsgController(DingTalkMsgService dingTalkMsgService) {
        this.dingTalkMsgService = dingTalkMsgService;
    }

    @GetMapping("sendDingTalkMsgText")
    @ApiOperation("根据手机号发送钉钉工作通知--文本消息")
    public Response<String> sendDingTalkMsgText(@RequestParam("mobiles") List<String> mobiles, String msg){
        return dingTalkMsgService.sendDingTalkMsgTextByMobiles(mobiles,msg);
    }
}
