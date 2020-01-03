package com.watilion.dingtalk.dao;

import com.watilion.dingtalk.entity.DingTalkUser;
import com.watilion.dingtalk.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Project: dingtalk
 * @Package: com.watilion.dingtalk.dao
 * @author: 吴腾龙
 * @Company: 浙江高速信息工程技术有限公司
 * @Created Date:	2019/12/26 14:37
 * <p>
 * <p>
 * Copyright @ 2019 www.zeiet.com – Confidential and Proprietary
 * <p>
 * 描述：
 */
@Mapper
@Repository
public interface UserDao {

    /**
     * 根据手机号获取用户信息
     * @param phone 手机号
     * @return 用户信息
     */
    User getUserByPhone(String phone);
}
