package com.example.swagger.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.swagger.common.utils.Md5Util;
import com.example.swagger.user.dao.PersonDao;
import com.example.swagger.user.dao.UserDao;
import com.example.swagger.user.domain.bo.PersonBO;
import com.example.swagger.user.domain.bo.UserBO;
import com.example.swagger.user.domain.bo.UserLoginBO;
import com.example.swagger.user.domain.po.PersonPO;
import com.example.swagger.user.domain.po.UserPO;
import com.example.swagger.user.enums.SexEnum;
import com.example.swagger.user.service.UserService;
import org.springframework.beans.BeanUtils;
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
    @Resource
    private PersonDao personDao;

    @Override
    public Boolean login(UserLoginBO userLoginBO) {
        String handleLoginPassword = Md5Util.handleLoginPassword(userLoginBO.getPassword());    //密码加密
        QueryWrapper<UserPO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name", userLoginBO.getUserName()).eq("password", handleLoginPassword);
        UserPO userPO = userDao.selectOne(queryWrapper);
        return (userPO != null) ? true : false;
    }

    @Override
    public void createUser(UserBO userBO) {
        //加密用户填写的密码
        userBO.setPassword(Md5Util.handleLoginPassword(userBO.getPassword()));

        PersonBO personBO = userBO.getPersonBO();
        PersonPO personPO = new PersonPO();
        BeanUtils.copyProperties(personBO, personPO);
        if (personBO.getSex() == 1) {
            personPO.setSex(SexEnum.MAN);
        } else if (personBO.getSex() == 2) {
            personPO.setSex(SexEnum.WOMAN);
        }
        personDao.insert(personPO);
        UserPO userPO = boToPo(userBO);
        userPO.setPersonId(personPO.getId());
        userDao.insert(userPO);
    }


    /**
     * b转p
     */
    private UserPO boToPo(UserBO userBO) {
        UserPO userPO = new UserPO();
        BeanUtils.copyProperties(userBO, userPO);
        return userPO;
    }


}
