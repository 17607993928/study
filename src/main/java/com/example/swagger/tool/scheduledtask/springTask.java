package com.example.swagger.tool.scheduledtask;

import com.example.swagger.weather.manager.GaodeWeather;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @创建人 xjs
 * @类描述 springTask定时任务
 * @创建时间 2020/4/11 0011 下午 16:42
 */
@Service
public class springTask {
    @Value("${weather.city}")
    private String city;
    @Value("${weather.type}")
    private String type;

    private static final Logger log = LoggerFactory.getLogger(springTask.class);

    @Autowired
    private GaodeWeather gaodeWeather;

//    task1是每隔5s执行一次，{秒} {分} {时} {日期} {月} {星期}
//    task2是延迟1s,每隔1S执行一次

    /*@Scheduled(cron = "1/5 * * * * *")
    public void task1(){
        log.info("springtask 定时任务！");
    }*/

    /*@Scheduled(initialDelay = 1000,fixedRate = 1*1000)
    public void task2(){
        log.info("springtask 定时任务！");
    }*/

    @Scheduled(initialDelay = 1000,fixedRate = 3600000)
    public void getWeather(){
        Map<String,String> map =new HashMap<>();
        map.put("city",city);
        map.put("type",type);
        gaodeWeather.GetWeatherByCity(map);
    }


}
