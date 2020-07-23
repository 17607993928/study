package com.example.swagger.common.utils;


import cn.hutool.crypto.digest.MD5;

/**
 * @类描述:加密工具
 * @创建人:xiejs
 * @创建时间:2020-7-23 13:20:36
 */
public class Md5Util {

    /**
     * 处理登录的用户密码
     * @param password 密码
     * @return
     */
    public static String handleLoginPassword(String password){
        MD5 md5=new MD5();
        String hex16 = md5.digestHex16(password);
        return hex16;
    }
}
