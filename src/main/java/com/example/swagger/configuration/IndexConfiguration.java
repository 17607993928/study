package com.example.swagger.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

import java.io.IOException;

/**
 *启动项目跳转到登录界面
 */
@Configuration
public class IndexConfiguration {
    private final static Logger log= LoggerFactory.getLogger(IndexConfiguration.class);

    @EventListener({ApplicationReadyEvent.class})
    void applicationReadyEvent() {
        log.info("应用已经准备就绪 ... 启动谷歌浏览器");
        String url = "http://localhost:8080/study/user/doLogin";
        Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec("rundll32 url.dll,FileProtocolHandler " + url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
