package com.example.swagger.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.swagger.common.utils.AjaxMessage;
import com.example.swagger.common.utils.Md5Util;
import com.example.swagger.common.utils.PinYin4jUtil;
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
import org.springframework.transaction.annotation.Transactional;

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
    public UserPO login(UserLoginBO userLoginBO) {
        String handleLoginPassword = Md5Util.handleLoginPassword(userLoginBO.getPassword());    //密码加密
        QueryWrapper<UserPO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name", userLoginBO.getUserName()).eq("password", handleLoginPassword);
        UserPO userPO = userDao.selectOne(queryWrapper);
        return userPO ;
    }

    @Override
    @Transactional
    public AjaxMessage createUser(UserBO userBO) {
        //检验数据库是否存在姓名相同的
        UserPO checkUser = userDao.selectOne(new QueryWrapper<UserPO>().eq("user_name", userBO.getUserName()));
        if(checkUser!=null){
            log.error("用户名重复！to-->"+userBO.getUserName());
            return AjaxMessage.error("用户名不能重复,请重新输入！");
        }
        PersonPO checkPerson = personDao.selectOne(new QueryWrapper<PersonPO>().eq("person_name", userBO.getPersonBO().getPersonName()));
        if(checkPerson!=null){
            log.error("姓名重复！to-->"+userBO.getPersonBO().getPersonName());
            return AjaxMessage.error("姓名不能重复,请重新输入！");
        }


        //加密用户填写的密码
        userBO.setPassword(Md5Util.handleLoginPassword(userBO.getPassword()));

        PersonBO personBO = userBO.getPersonBO();
        PersonPO personPO = new PersonPO();
        BeanUtils.copyProperties(personBO, personPO);

        //性别赋值
        if (personBO.getSex() == 1) {
            personPO.setSex(SexEnum.MAN);
        } else if (personBO.getSex() == 2) {
            personPO.setSex(SexEnum.WOMAN);
        }

        //汉字转成大写拼音
        personPO.setPersonCode(PinYin4jUtil.hanziToPinyin(personBO.getPersonName(),"").toUpperCase());

        personDao.insert(personPO);
        UserPO userPO = boToPo(userBO);
        userPO.setPersonId(personPO.getId());
        userDao.insert(userPO);

        return AjaxMessage.success("注册成功");
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
