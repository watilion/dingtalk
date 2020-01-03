package com.watilion.dingtalk.service;

import com.dingtalk.api.response.OapiMessageCorpconversationAsyncsendV2Response;
import com.taobao.api.ApiException;
import com.watilion.dingtalk.entity.Response;

import java.util.List;

/**
 * @Project: dingtalk
 * @Package: com.watilion.dingtalk.service
 * @author: 吴腾龙
 * @Company: 浙江高速信息工程技术有限公司
 * @Created Date:	2019/12/26 20:26
 * <p>
 * <p>
 * Copyright @ 2019 www.zeiet.com – Confidential and Proprietary
 * <p>
 * 描述：
 */
public interface DingTalkMsgService {

    /**
     * 根据手机号发送钉钉工作通知--文本消息
     * @param mobiles 手机号
     * @param msg 消息内容
     * @return 发送结果
     */
    Response<String> sendDingTalkMsgTextByMobiles(List<String> mobiles, String msg);

    /**
     * 根据用户ids发送文本消息
     * @param userIds 用户id，使用“,”分隔
     * @param msg 文本消息内容
     * @return 任务详情
     * @throws ApiException 接口异常
     */
    OapiMessageCorpconversationAsyncsendV2Response sendDingTalkMsgText(String userIds, String msg) throws ApiException;

    /**
     * 保存钉钉推送信息到数据库
     * @param taskId 钉钉返回任务id
     * @param userIds 用户列表
     * @param content 推送文本
     */
    void saveDingTalkMessage(long taskId,List<String> userIds,String content);
}
