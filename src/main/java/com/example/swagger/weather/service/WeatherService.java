package com.example.swagger.weather.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.swagger.weather.domain.po.WeatherPO;

import java.util.Date;
import java.util.List;

/**
 * @类描述:天气管理
 * @创建人:xiejs
 * @创建时间:2020-7-21 16:35:48
 */
public interface WeatherService extends IService<WeatherPO> {
    /**
     * 根据城市和日期获取天气
     * @return
     */
    List<WeatherPO> getWeatherByCityAndDate(String city, Date date);
}
