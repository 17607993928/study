package com.example.swagger.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.swagger.user.domain.bo.UserLoginBO;
import com.example.swagger.user.domain.po.UserPO;

/**
 * @类描述:用户service
 * @创建人:xiejs
 * @创建时间:2020-7-17 13:14:07
 */

public interface UserService extends IService<UserPO> {
    /**
     * 用户登录
     * @param userLoginBO
     * @return 成功true 失败false
     */
    Boolean login(UserLoginBO userLoginBO);
}
