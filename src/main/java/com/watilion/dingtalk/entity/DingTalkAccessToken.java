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
 * @Created Date:	2019/12/26 15:07
 * <p>
 * <p>
 * Copyright @ 2019 www.zeiet.com – Confidential and Proprietary
 * <p>
 * 描述：
 */

@Data
@ApiModel(description = "钉钉AccessToken实体")
public class DingTalkAccessToken implements Serializable {

    private static final long serialVersionUID = -4175666182887928788L;

    @ApiModelProperty(value = "钉钉AccessToken信息")
    private String accessToken;

    @ApiModelProperty(value = "钉钉AccessToken获取时间戳")
    private Long accessTokenDate;
}
