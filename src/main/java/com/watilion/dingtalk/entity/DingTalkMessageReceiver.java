package com.watilion.dingtalk.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Project: dingtalk
 * @Package: com.watilion.dingtalk.entity
 * @author: 吴腾龙
 * @Company: 浙江高速信息工程技术有限公司
 * @Created Date:	2019/12/27 15:18
 * <p>
 * <p>
 * Copyright @ 2019 www.zeiet.com – Confidential and Proprietary
 * <p>
 * 描述：
 */

@Data
@ApiModel(description = "钉钉推送消息接受者信息")
public class DingTalkMessageReceiver implements Serializable {
    private static final long serialVersionUID = -5570688514640834650L;

    @ApiModelProperty("主键id")
    private Integer id;

    @ApiModelProperty("钉钉用户id")
    private String userId;

    @ApiModelProperty("系统用户id")
    private String tblUserId;

    @ApiModelProperty("信息推送任务id")
    private Integer messageId;

    @ApiModelProperty("发送状态，0-发送中，1-被限流用户，2-发送失败，3-已读，4-未读，5-无效部门")
    private int status = 0;
}
