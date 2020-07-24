package com.example.swagger.user.proxy;

import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.mail.MailUtil;
import com.example.swagger.common.constant.QuotesMap;
import com.example.swagger.common.utils.DateUtil;
import com.example.swagger.user.exception.MailIsNullException;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.Inet4Address;
import java.util.Date;
import java.util.Map;
import java.util.Random;

/**
 * @类描述:子线程发送邮箱
 * @创建人:xiejs
 * @创建时间:2020-7-21 14:27:02
 */
@Data
public class SendMail implements Runnable {
    private static final Logger log = LoggerFactory.getLogger(SendMail.class);

    private String mail;

    private String subject;

    private String content;




    @Override
    public void run() {
        if(StrUtil.isBlank(mail)){
            throw new MailIsNullException("邮箱未找到！");
        }
        try {
            String send = MailUtil.send(mail, subject,
                    content+"\n\n登录时间:"+DateUtil.dateToString(new Date(),DateUtil.DATE_FORMAT_TIME_T)+"\n\n" +
                            "设备IP地址:"+ Inet4Address.getLocalHost().getHostAddress()+
                            "\n\n"+handleMap(), false);
            log.info("邮件已发送！"+send);
        } catch (Exception e) {
            log.info("邮件发送失败！"+e);
        }
    }

    /**
     * 处理语录
     * @return
     */
    private String handleMap(){
        //早上 5:00到11:00
        Date date=new Date();
        String hh = DateUtil.dateToString(date, "HH");
        int dateNum = Integer.parseInt(hh);

        Map<Integer, String> quotesMap =null;
        if(5<=dateNum && 11>dateNum){
            quotesMap = QuotesMap.morningQuotesMap;
        }else if(11<=dateNum && 14>dateNum){
            quotesMap=QuotesMap.noonQuotesMap;
        }else if(18<=dateNum && 24>dateNum){
            quotesMap=QuotesMap.nightQuotesMap;
        }else {
            quotesMap=QuotesMap.allDayQuotesMap;
        }


        if(quotesMap==null || quotesMap.size()==0){
            return "";
        }

        int max = quotesMap.size();
        int min=0;
        Random random = new Random();
        int num = random.nextInt(max)%(max-min+1) + min;
        String quotes = quotesMap.get(num);
        return quotes;


    }
}
