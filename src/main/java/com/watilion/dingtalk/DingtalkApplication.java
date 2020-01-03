package com.watilion.dingtalk;

/**
 * @Project: dingtalk
 * @Package: com.watilion.dingtalk.controller
 * @author: 吴腾龙
 * @Company: 浙江高速信息工程技术有限公司
 * @Created Date:	2019/12/26 10:47
 * <p>
 * <p>
 * Copyright @ 2019 www.zeiet.com – Confidential and Proprietary
 * <p>
 * 描述：
 */
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.watilion.dingtalk.*.dao","com.watilion.dingtalk.dao"})
public class DingtalkApplication {

    public static void main(String[] args) {
        SpringApplication.run(DingtalkApplication.class, args);
    }

}
