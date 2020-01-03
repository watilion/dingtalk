package com.watilion.dingtalk.service;

import com.dingtalk.api.response.OapiUserGetByMobileResponse;
import com.dingtalk.api.response.OapiUserGetResponse;
import com.dingtalk.api.response.OapiUserGetuserinfoResponse;
import com.taobao.api.ApiException;
import com.watilion.dingtalk.entity.DingTalkUser;
import com.watilion.dingtalk.entity.Response;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Project: dingtalk
 * @Package: com.watilion.dingtalk.service
 * @author: 吴腾龙
 * @Company: 浙江高速信息工程技术有限公司
 * @Created Date:	2019/12/26 14:38
 * <p>
 * <p>
 * Copyright @ 2019 www.zeiet.com – Confidential and Proprietary
 * <p>
 * 描述：
 */
public interface UserService {

    /**
     * 根据钉钉免密获取用户手机号等信息
     * @param code 免密码
     * @return 用户信息
     */
    Response<DingTalkUser> getMobileByCode(String code);

    /**
     * 根据免密获取钉钉用户信息
     * @param code 免密信息
     * @return 钉钉用户信息
     * @throws ApiException 获取异常
     */
    OapiUserGetuserinfoResponse getUserIdByCode(String code) throws ApiException;

    /**
     * 根据用户id获取手机号
     * @param userId 用户id
     * @return 手机号信息
     * @throws ApiException
     */
    OapiUserGetResponse getMobileByUserId(String userId) throws ApiException;

    /**
     * 根据用户手机号获取钉钉用户id
     * @param mobile 手机号
     * @return 钉钉用户id
     */
    Response<String> getDingTalkUserIdByMobile(String mobile);

    /**
     *
     * @param mobile
     * @return
     * @throws ApiException
     */
    OapiUserGetByMobileResponse oApiUserGetByMobile(String mobile) throws ApiException;


}
