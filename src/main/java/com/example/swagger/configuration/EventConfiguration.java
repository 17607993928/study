package com.example.swagger.configuration;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;

/**
 * @类描述:事件监听
 * @创建人:xiejs
 * @创建时间:2020-7-21 13:49:14
 */
@Configuration
public class EventConfiguration implements ApplicationListener<ApplicationStartedEvent> {

    /**
     * ApplicationStartingEvent：springboot框架开始启动的事件。
     * ApplicationStartedEvent：springboot框架启动完成，context和bean都已创建完毕。
     * ApplicationEnvironmentPreparedEvent：springboot框架环境准备完毕，context还没有创建完成，bean也没有完成创建。
     * ApplicationPreparedEvent：springboot框架启动，context创建完，bean没有创建。
     * ApplicationFailedEvent：springboot框架启动失败。
     * @param event
     */
    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {



    }
}
