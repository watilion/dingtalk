package com.watilion.dingtalk.dao;

import com.watilion.dingtalk.entity.DingTalkMessage;
import com.watilion.dingtalk.entity.DingTalkMessageReceiver;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Project: dingtalk
 * @Package: com.watilion.dingtalk.dao
 * @author: 吴腾龙
 * @Company: 浙江高速信息工程技术有限公司
 * @Created Date:	2019/12/27 15:12
 * <p>
 * <p>
 * Copyright @ 2019 www.zeiet.com – Confidential and Proprietary
 * <p>
 * 描述：
 */

@Mapper
@Repository
public interface DingTalkMessageDao {

    /**
     * 信息保存至数据库
     * @param dingTalkMessage 需要保存的数据
     */
    void saveDingTalkMessage(DingTalkMessage dingTalkMessage);

    /**
     * 保存钉钉推送用户信息
     * @param dingTalkMessageReceiver 用户信息
     */
    void saveDingTalkMessageReceiver(DingTalkMessageReceiver dingTalkMessageReceiver);
}
