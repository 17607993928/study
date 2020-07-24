package com.example.swagger.user.proxy;

import com.example.swagger.user.domain.bo.UserLoginBO;
import com.example.swagger.user.domain.po.PersonPO;
import com.example.swagger.user.domain.po.UserPO;
import com.example.swagger.user.service.PersonService;
import com.example.swagger.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @类描述:发送邮箱代理
 * @创建人:xiejs
 * @创建时间:2020-7-21 14:04:02
 */
@Component
public class LoginProxy {
    @Autowired
    private UserService userService;
    @Autowired
    private PersonService personService;

    public boolean sendMailLogin(UserLoginBO userLoginBO){
        UserPO userPO = userService.login(userLoginBO);
        PersonPO personPO = personService.getById(userPO.getPersonId());

        //密码验证成功开辟线程执行邮箱通知
        if(userPO!=null){
            SendMail sendMail=new SendMail();
            sendMail.setSubject("登录提醒!");
            sendMail.setContent("用户"+userLoginBO.getUserName()+"已登录！");
            if(personPO!=null){
                sendMail.setMail(personPO.getEmail());
            }

            Thread thread = new Thread(sendMail, "sendMail");
            thread.start();
        }
        if(userPO==null){
            return false;
        }
        return true;
    }



}
