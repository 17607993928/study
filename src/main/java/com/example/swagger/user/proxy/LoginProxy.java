package com.example.swagger.user.proxy;

import com.example.swagger.user.domain.bo.UserLoginBO;
import com.example.swagger.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @类描述:发送邮箱代理
 * @创建人:xiejs
 * @创建时间:2020-7-21 14:04:02
 */
@Component
public class LoginProxy {
    @Autowired
    private UserService userService;

    public LoginProxy(){

    }

    public boolean sendMailLogin(UserLoginBO userLoginBO){
        Boolean login = userService.login(userLoginBO);

        //密码验证成功开辟线程执行邮箱通知
        if(login){
            SendMail sendMail=new SendMail("登录提醒","用户"+userLoginBO.getUserName()+"已登录！"+"\n"+new Date());
            Thread thread = new Thread(sendMail, "sendMail");
            thread.start();
        }

        return login;
    }



}
