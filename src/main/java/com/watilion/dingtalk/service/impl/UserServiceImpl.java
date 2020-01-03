package com.watilion.dingtalk.service.impl;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiUserGetByMobileRequest;
import com.dingtalk.api.request.OapiUserGetRequest;
import com.dingtalk.api.request.OapiUserGetuserinfoRequest;
import com.dingtalk.api.response.OapiUserGetByMobileResponse;
import com.dingtalk.api.response.OapiUserGetResponse;
import com.dingtalk.api.response.OapiUserGetuserinfoResponse;
import com.taobao.api.ApiException;
import com.watilion.dingtalk.dao.UserDao;
import com.watilion.dingtalk.entity.DingTalkUser;
import com.watilion.dingtalk.entity.Response;
import com.watilion.dingtalk.entity.User;
import com.watilion.dingtalk.service.UserService;
import com.watilion.dingtalk.utils.DingTalkAccessTokenUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @Project: dingtalk
 * @Package: com.watilion.dingtalk.service.impl
 * @author: 吴腾龙
 * @Company: 浙江高速信息工程技术有限公司
 * @Created Date:	2019/12/26 14:39
 * <p>
 * <p>
 * Copyright @ 2019 www.zeiet.com – Confidential and Proprietary
 * <p>
 * 描述：
 */

@Service
public class UserServiceImpl implements UserService {

    @Value("${dingtalk.dingTalkUrl}")
    private String dingTalkUrl;

    private final UserDao userDao;
    private DingTalkAccessTokenUtil dingTalkAccessTokenUtil;

    public UserServiceImpl(UserDao userDao,DingTalkAccessTokenUtil dingTalkAccessTokenUtil) {
        this.userDao = userDao;
        this.dingTalkAccessTokenUtil = dingTalkAccessTokenUtil;
    }
    @Override
    public Response<DingTalkUser> getMobileByCode(String code) {
        Response<DingTalkUser> response = new Response<>();
        try {
            //根据免密登录code获取钉钉userId
            OapiUserGetuserinfoResponse userInfoResponse = this.getUserIdByCode(code);
            String userId;
            if (userInfoResponse.isSuccess()) {
                userId = userInfoResponse.getUserid();
                //根据userid获取用户信息
                OapiUserGetResponse userResponse = this.getMobileByUserId(userId);
                if (userResponse.isSuccess()) {
                    String mobile = userResponse.getMobile();
                    DingTalkUser dingTalkUser = new DingTalkUser();
                    dingTalkUser.setUserId(userId);
                    dingTalkUser.setPhone(mobile);
                    dingTalkUser.setUserName(userResponse.getName());
                    if (StringUtils.isNotBlank(userInfoResponse.getDeviceId())) {
                        dingTalkUser.setUserName(userInfoResponse.getDeviceId());
                    }

                    //根据用户手机号获取系统用户信息
                    User user = userDao.getUserByPhone(mobile);
                    dingTalkUser.setUser(user);
                    response.success(dingTalkUser);
                }else {
                    response.failure("获取用户手机号失败：-------" + userResponse.getErrmsg());
                }
            }else {
                response.failure("获取用户id失败：-------" + userInfoResponse.getErrmsg());
            }
        } catch (ApiException e) {
            e.printStackTrace();
            response.failure("获取用户手机号异常：-------" + e.getMessage());
        }
        return response;
    }

    @Override
    public OapiUserGetuserinfoResponse getUserIdByCode(String code) throws ApiException {
        String accessToken = dingTalkAccessTokenUtil.getAccessToken();
        DingTalkClient client = new DefaultDingTalkClient(dingTalkUrl + "user/getuserinfo");
        OapiUserGetuserinfoRequest request = new OapiUserGetuserinfoRequest();
        request.setCode(code);
        request.setHttpMethod("GET");
        return client.execute(request,accessToken);
    }

    @Override
    public OapiUserGetResponse getMobileByUserId(String userId) throws ApiException {
        String accessToken = dingTalkAccessTokenUtil.getAccessToken();
        DingTalkClient client = new DefaultDingTalkClient(dingTalkUrl + "user/get");
        OapiUserGetRequest request = new OapiUserGetRequest();
        request.setUserid(userId);
        request.setHttpMethod("GET");
        return client.execute(request, accessToken);
    }

    @Override
    public Response<String> getDingTalkUserIdByMobile(String mobile) {
        Response<String> response = new Response<>();
        try {
            OapiUserGetByMobileResponse oapiUserGetByMobileResponse = oApiUserGetByMobile(mobile);
            if (oapiUserGetByMobileResponse.isSuccess()){
                response.success(oapiUserGetByMobileResponse.getUserid(),"获取钉钉用户id成功");
            } else {
                response.failure(oapiUserGetByMobileResponse.getErrmsg(),"获取钉钉用户id失败");
            }
        } catch (ApiException e) {
            e.printStackTrace();
            response.failure(e.getMessage(),"获取钉钉用户id失败");
        }
        return response;
    }

    @Override
    public OapiUserGetByMobileResponse oApiUserGetByMobile(String mobile) throws ApiException {
        String accessToken = dingTalkAccessTokenUtil.getAccessToken();
        DingTalkClient client = new DefaultDingTalkClient(dingTalkUrl + "user/get_by_mobile");
        OapiUserGetByMobileRequest request = new OapiUserGetByMobileRequest();
        request.setMobile(mobile);
        return client.execute(request,accessToken);
    }

}
