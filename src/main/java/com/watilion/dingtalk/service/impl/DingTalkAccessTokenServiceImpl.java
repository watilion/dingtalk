package com.watilion.dingtalk.service.impl;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.request.OapiGettokenRequest;
import com.dingtalk.api.response.OapiGettokenResponse;
import com.taobao.api.ApiException;
import com.watilion.dingtalk.service.DingTalkAccessTokenService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @Project: dingtalk
 * @Package: com.watilion.dingtalk.service.impl
 * @author: 吴腾龙
 * @Company: 浙江高速信息工程技术有限公司
 * @Created Date:	2019/12/26 15:10
 * <p>
 * <p>
 * Copyright @ 2019 www.zeiet.com – Confidential and Proprietary
 * <p>
 * 描述：
 */

@Service
public class DingTalkAccessTokenServiceImpl implements DingTalkAccessTokenService {

    @Value("${dingtalk.appKey}")
    private String appKey;
    @Value("${dingtalk.AppSecret}")
    private String appSecret;
    @Value("${dingtalk.dingTalkUrl}")
    private String dingTalkUrl;

    @Override
    public String requestDingTalkAccessToken() throws ApiException {
        DefaultDingTalkClient client = new DefaultDingTalkClient(dingTalkUrl +"gettoken");
        OapiGettokenRequest request = new OapiGettokenRequest();
        request.setAppkey(appKey);
        request.setAppsecret(appSecret);
        request.setHttpMethod("GET");
        OapiGettokenResponse response = client.execute(request);
        if (response.isSuccess()) {
            return response.getAccessToken();
        }else {
            return null;
        }
    }
}
