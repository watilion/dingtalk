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
 * @Created Date:	2019/12/26 15:27
 * <p>
 * <p>
 * Copyright @ 2019 www.zeiet.com – Confidential and Proprietary
 * <p>
 * 描述：
 */

@Data
@ApiModel(description = "钉钉用户信息实体")
public class User implements Serializable {
    private static final long serialVersionUID = -3196031921200232558L;

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "钉钉用户名称")
    private String userName;

    @ApiModelProperty(value = "用户手机号")
    private String phone;
}
