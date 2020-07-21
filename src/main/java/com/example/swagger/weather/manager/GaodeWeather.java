package com.example.swagger.weather.manager;

import java.util.Map;

/**
 * @创建人 xjs
 * @类描述 TODO
 * @创建时间 2020/4/10 0010 下午 21:47
 */
public interface GaodeWeather {
    /**
     *  执行高德天气PAI
     * @param parm 入参
     * @return
     */
    void GetWeatherByCity(Map<String, String> parm);
}
