package com.watilion.dingtalk.service.impl;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiMessageCorpconversationAsyncsendV2Request;
import com.dingtalk.api.response.OapiMessageCorpconversationAsyncsendV2Response;
import com.dingtalk.api.response.OapiUserGetByMobileResponse;
import com.taobao.api.ApiException;
import com.watilion.dingtalk.dao.DingTalkMessageDao;
import com.watilion.dingtalk.entity.DingTalkMessage;
import com.watilion.dingtalk.entity.DingTalkMessageReceiver;
import com.watilion.dingtalk.entity.Response;
import com.watilion.dingtalk.service.DingTalkMsgService;
import com.watilion.dingtalk.service.UserService;
import com.watilion.dingtalk.utils.DingTalkAccessTokenUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Project: dingtalk
 * @Package: com.watilion.dingtalk.service.impl
 * @author: 吴腾龙
 * @Company: 浙江高速信息工程技术有限公司
 * @Created Date:	2019/12/26 20:27
 * <p>
 * <p>
 * Copyright @ 2019 www.zeiet.com – Confidential and Proprietary
 * <p>
 * 描述：
 */

@Service
public class DingTalkMsgServiceImpl implements DingTalkMsgService {

    @Value("${dingtalk.dingTalkUrl}")
    private String dingTalkUrl;
    @Value("${dingtalk.AgentId}")
    private long agentId;

    private final UserService userService;
    private final DingTalkAccessTokenUtil dingTalkAccessTokenUtil;
    private final DingTalkMessageDao dingTalkMessageDao;

    public DingTalkMsgServiceImpl(UserService userService, DingTalkAccessTokenUtil dingTalkAccessTokenUtil,
                                  DingTalkMessageDao dingTalkMessageDao) {
        this.userService = userService;
        this.dingTalkAccessTokenUtil = dingTalkAccessTokenUtil;
        this.dingTalkMessageDao = dingTalkMessageDao;
    }

    @Override
    public Response<String> sendDingTalkMsgTextByMobiles(List<String> mobiles, String msg) {
        Response<String> response = new Response<>();
        List<String> userIds = new ArrayList<>();
        for (String mobile : mobiles) {
            try {
                OapiUserGetByMobileResponse oapiUserGetByMobileResponse = userService.oApiUserGetByMobile(mobile);
                if (oapiUserGetByMobileResponse.isSuccess()) {
                    userIds.add(oapiUserGetByMobileResponse.getUserid());
                }
            } catch (ApiException e) {
                e.printStackTrace();
            }
        }
        if (userIds.isEmpty()){
            return response.failure("获取钉钉用户id失败","发送失败");
        }
        try {
            OapiMessageCorpconversationAsyncsendV2Response asyncsendV2Response = sendDingTalkMsgText(String.join(",",userIds),msg);
            if (asyncsendV2Response.isSuccess()) {
                response.success(asyncsendV2Response.getTaskId().toString(),"发送成功");
                saveDingTalkMessage(asyncsendV2Response.getTaskId(),userIds,msg);
            } else {
                response.failure(asyncsendV2Response.getErrmsg(),"发送失败");
            }

        } catch (ApiException e) {
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public OapiMessageCorpconversationAsyncsendV2Response sendDingTalkMsgText(String userIds, String msg) throws ApiException {
        String accessToken = dingTalkAccessTokenUtil.getAccessToken();
        DingTalkClient client = new DefaultDingTalkClient(dingTalkUrl + "topapi/message/corpconversation/asyncsend_v2");
        OapiMessageCorpconversationAsyncsendV2Request request = new OapiMessageCorpconversationAsyncsendV2Request();
        request.setUseridList(userIds);
        request.setAgentId(agentId);
        request.setToAllUser(false);

        OapiMessageCorpconversationAsyncsendV2Request.Msg message= new OapiMessageCorpconversationAsyncsendV2Request.Msg();
        message.setMsgtype("text");
        message.setText(new OapiMessageCorpconversationAsyncsendV2Request.Text());
        message.getText().setContent(msg);
        request.setMsg(message);
        return client.execute(request,accessToken);
    }

    @Override
    public void saveDingTalkMessage(long taskId,List<String> userIds,String content){
        DingTalkMessage dingTalkMessage = new DingTalkMessage();
        dingTalkMessage.setContent(content);
        dingTalkMessage.setTaskId(taskId);
        dingTalkMessageDao.saveDingTalkMessage(dingTalkMessage);
        for (String userId : userIds) {
            DingTalkMessageReceiver dingTalkMessageReceiver = new DingTalkMessageReceiver();
            dingTalkMessageReceiver.setMessageId(dingTalkMessage.getId());
            dingTalkMessageReceiver.setUserId(userId);
            dingTalkMessageDao.saveDingTalkMessageReceiver(dingTalkMessageReceiver);
        }
    }
}
