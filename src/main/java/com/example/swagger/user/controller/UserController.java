package com.example.swagger.user.controller;

import com.example.swagger.common.utils.AjaxMessage;
import com.example.swagger.user.domain.bo.UserLoginBO;
import com.example.swagger.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @类描述:用户控制器
 * @创建人:xiejs
 * @创建时间:2020-7-16 16:37:24
 */
@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping("doLogin")
    public String doLogin(){
        return "html/login";
    }

    @PostMapping("login")
    public AjaxMessage login(UserLoginBO userLoginBO){
        Boolean login = userService.login(userLoginBO);
        if(!login){
            return AjaxMessage.error("密码错误！");
        }else {
            return AjaxMessage.success("登录成功！");
        }

    }



}
