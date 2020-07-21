package com.example.swagger.user.proxy;

import cn.hutool.extra.mail.MailUtil;
import lombok.Data;

/**
 * @类描述:子线程发送邮箱
 * @创建人:xiejs
 * @创建时间:2020-7-21 14:27:02
 */
@Data
public class SendMail implements Runnable {
    private String subject;

    private String content;

    public SendMail(String subject,String content){
        this.subject=subject;
        this.content=content;
    }


    @Override
    public void run() {
        try {
            MailUtil.send("1294405880@qq.com", getSubject(), getContent(), false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
