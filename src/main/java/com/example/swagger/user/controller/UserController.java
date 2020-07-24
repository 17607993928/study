package com.example.swagger.user.controller;

import com.example.swagger.common.utils.AjaxMessage;
import com.example.swagger.common.utils.JwtUtil;
import com.example.swagger.common.utils.VerifyCode;
import com.example.swagger.user.domain.bo.UserBO;
import com.example.swagger.user.domain.bo.UserLoginBO;
import com.example.swagger.user.proxy.LoginProxy;
import com.example.swagger.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @类描述:用户控制器
 * @创建人:xiejs
 * @创建时间:2020-7-16 16:37:24
 */
@Controller
@RequestMapping("user")
@Api(tags = "用户管理")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private LoginProxy loginProxy;
    @Autowired
    private JwtUtil jwtUtil;

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Value("${verifyCode.width}")
    private int width;
    @Value("${verifyCode.height}")
    private int height;


    @GetMapping("doLogin")
    public String doLogin() {
        return "html/login";
    }

    @PostMapping("login")
    @ResponseBody
    @ApiOperation("登录")
    public AjaxMessage login(UserLoginBO userLoginBO, HttpServletRequest request) {
        //从session中获取验证码
        String verifyCode = (String) request.getSession().getAttribute("verifyCode");

        if (!verifyCode.equalsIgnoreCase(userLoginBO.getVerifyCode())) {
            return AjaxMessage.error("验证码错误！");
        }

        Boolean login = loginProxy.sendMailLogin(userLoginBO);
        if(!login){
            return AjaxMessage.error("账号或密码错误！");
        }

        //其他数据以map集合存放在token中
        Map<String, Object> dataMap = new HashMap<>();

        //生成token并存入数据返回
        String token = jwtUtil.createJwt(userLoginBO.getUserName(), userLoginBO.getPassword(), dataMap);
        return AjaxMessage.success().data(token);
    }

    @ApiOperation("退出")
    @GetMapping("logout")
    @ResponseBody
    public AjaxMessage logout(HttpServletRequest request) {
        try {
            request.logout();
        } catch (ServletException e) {
            e.printStackTrace();
        }
        return AjaxMessage.success("退出成功");
    }

    @ApiOperation("注册用户")
    @PostMapping("createUser")
    @ResponseBody
    public AjaxMessage createUser(UserBO userBO){
        AjaxMessage message = userService.createUser(userBO);
        return message;
    }




    /**
     * 生成验证码
     */
    @ApiOperation("生成验证码")
    @GetMapping("getVerifyCode")
    public void getVerificationCode(HttpServletResponse response, HttpServletRequest request) {
        try {
            //生成对应宽高的初始图片
            BufferedImage verifyImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

            //单独的一个类方法，出于代码复用考虑，进行了封装。
            //功能是生成验证码字符并加上噪点，干扰线，返回值为验证码字符
            String randomText = VerifyCode.drawRandomText(width, height, verifyImg);

            request.getSession().setAttribute("verifyCode", randomText);

            response.setContentType("image/png");//必须设置响应内容类型为图片，否则前台不识别
            OutputStream os = response.getOutputStream(); //获取文件输出流
            ImageIO.write(verifyImg, "png", os);//输出图片流
            os.flush();
            os.close();//关闭流
        } catch (IOException e) {
            this.log.error(e.getMessage());
        }
    }


}
