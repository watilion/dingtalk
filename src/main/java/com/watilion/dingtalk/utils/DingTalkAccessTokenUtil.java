package com.watilion.dingtalk.utils;

import com.taobao.api.ApiException;
import com.watilion.dingtalk.entity.DingTalkAccessToken;
import com.watilion.dingtalk.service.DingTalkAccessTokenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


/**
 * @Project: dingtalk
 * @Package: com.watilion.dingtalk.utils
 * @author: 吴腾龙
 * @Company: 浙江高速信息工程技术有限公司
 * @Created Date:	2019/12/26 15:09
 * <p>
 * <p>
 * Copyright @ 2019 www.zeiet.com – Confidential and Proprietary
 * <p>
 * 描述：
 */

@Slf4j
@Component
public class DingTalkAccessTokenUtil {

    private final DingTalkAccessTokenService dingTalkAccessTokenService;
    /**
     * 保存accessToken信息对象
     */
    private DingTalkAccessToken accessToken;

    public DingTalkAccessTokenUtil(DingTalkAccessTokenService dingTalkAccessTokenService) {
        this.dingTalkAccessTokenService = dingTalkAccessTokenService;
    }

    public String getAccessToken () throws ApiException {
        Long nowTime = System.currentTimeMillis();
        if (accessToken != null) {
            boolean isTimeOut = accessToken.getAccessToken() == null || (accessToken.getAccessTokenDate() != null && nowTime - accessToken.getAccessTokenDate() > 7200000);
            if (isTimeOut) {
                //如果保存的时间戳超过有效时间，则重新获取accessToken
                log.info("accessToken过期，重新获取,当前时间戳为{}",nowTime);
                String dingTalkAccessTokenStr = dingTalkAccessTokenService.requestDingTalkAccessToken();
                this.accessToken.setAccessToken(dingTalkAccessTokenStr);
                this.accessToken.setAccessTokenDate(nowTime);
            }
        }else {
            //如过保存的accessToken信息为空，则从接口获取accessToken
            log.info("当前未获取到accessToken信息，重新获取,当前时间戳为{}",nowTime);
            this.accessToken = new DingTalkAccessToken();
            String dingTalkAccessTokenStr = dingTalkAccessTokenService.requestDingTalkAccessToken();
            this.accessToken.setAccessToken(dingTalkAccessTokenStr);
            this.accessToken.setAccessTokenDate(nowTime);
        }
        return this.accessToken.getAccessToken();
    }
}
