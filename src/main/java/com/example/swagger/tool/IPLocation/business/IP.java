package com.example.swagger.tool.IPLocation.business;

import cn.hutool.http.HttpUtil;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;

import java.util.Map;

/**
 * @创建人 xjs
 * @类描述 TODO
 * @创建时间 2020/3/22 0022 下午 12:35
 */
public class IP {
    @Value("weather_key")
    private String key;


    public  String excute(Map<String,String> parm){
        String ip=parm.get("ip");
        String url="https://restapi.amap.com/v3/ip?ip="+ip+"&key="+key;
        return HttpUtil.get(url);
    }

    @SneakyThrows
    public  String GetWeatherByCity(Map<String,String> parm){

        return excute(parm);
    }
}
