package com.example.swagger.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.swagger.user.dao.UserDao;
import com.example.swagger.user.domain.bo.UserLoginBO;
import com.example.swagger.user.domain.po.UserPO;
import com.example.swagger.user.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @类描述:
 * @创建人:xiejs
 * @创建时间:
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, UserPO> implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public Boolean login(UserLoginBO userLoginBO) {
        QueryWrapper<UserPO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name", userLoginBO.getUserName()).eq("password", userLoginBO.getPassword());
        UserPO userPO = userDao.selectOne(queryWrapper);
        if (userPO != null) {
            return true;
        } else {
            return false;
        }
    }


}
