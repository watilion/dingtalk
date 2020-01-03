package com.watilion.dingtalk.service;

import com.taobao.api.ApiException;

/**
 * @Project: dingtalk
 * @Package: com.watilion.dingtalk.service
 * @author: 吴腾龙
 * @Company: 浙江高速信息工程技术有限公司
 * @Created Date:	2019/12/26 15:10
 * <p>
 * <p>
 * Copyright @ 2019 www.zeiet.com – Confidential and Proprietary
 * <p>
 * 描述：
 */
public interface DingTalkAccessTokenService {

    /**
     * 请求accesstoken信息
     * @return token信息
     * @throws ApiException 获取异常
     */
    String requestDingTalkAccessToken() throws ApiException;
}
