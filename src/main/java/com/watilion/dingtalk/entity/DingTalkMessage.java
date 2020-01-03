package com.watilion.dingtalk.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Project: dingtalk
 * @Package: com.watilion.dingtalk.entity
 * @author: 吴腾龙
 * @Company: 浙江高速信息工程技术有限公司
 * @Created Date:	2019/12/27 15:13
 * <p>
 * <p>
 * Copyright @ 2019 www.zeiet.com – Confidential and Proprietary
 * <p>
 * 描述：
 */

@Data
@ApiModel(description = "钉钉信息保存实体")
public class DingTalkMessage implements Serializable {

    private static final long serialVersionUID = -3761904983944892931L;

    @ApiModelProperty("主键id")
    private Integer id;

    @ApiModelProperty("消息内容")
    private String content;

    @ApiModelProperty("钉钉发送任务id")
    private long taskId;

    @ApiModelProperty("钉钉消息接受者信息")
    private List<DingTalkMessageReceiver> receivers;
}
