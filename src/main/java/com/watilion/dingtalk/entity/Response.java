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
 * @Created Date:	2019/12/26 15:31
 * <p>
 * <p>
 * Copyright @ 2019 www.zeiet.com – Confidential and Proprietary
 * <p>
 * 描述：
 */

@Data
@ApiModel(description = "返回消息实体")
public class Response<T> implements Serializable {

    private static final long serialVersionUID = 1378745829062873980L;

    private static final String OK = "ok";
    private static final String ERROR = "error";

    @ApiModelProperty(value = "返回状态")
    private boolean success;
    @ApiModelProperty(value = "返回信息")
    private String message;
    @ApiModelProperty(value = "数据对象")
    private T data;

    public Response<T> success(){
        this.success = true;
        this.message = OK;
        return this;
    }

    public Response<T> success(T data){
        this.success = true;
        this.message = OK;
        this.data = data;
        return this;
    }

    public Response<T> success(String message){
        this.success = true;
        this.message = message;
        return this;
    }

    public Response<T> success(T data,String message){
        this.success = true;
        this.message = message;
        this.data = data;
        return this;
    }

    public Response<T> failure(){
        this.success = false;
        this.message = ERROR;
        return this;
    }
    public Response<T> failure(T data){
        this.success = false;
        this.message = ERROR;
        this.data = data;
        return this;
    }

    public Response<T> failure(String message){
        this.success = false;
        this.message = message;
        return this;
    }

    public Response<T> failure(T data, String message){
        this.success = false;
        this.message = message;
        this.data = data;
        return this;
    }
}
