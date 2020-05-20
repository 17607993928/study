package com.example.swagger.common.tool.weather.business.controller;

import com.example.swagger.common.tool.weather.business.GaodeWeather;
import com.example.swagger.common.utils.AjaxMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @创建人 xjs
 * @类描述 TODO
 * @创建时间 2020/4/10 0010 下午 21:53
 */
@RestController
@Api(tags = {"高德天气"})
@RequestMapping("/weather")
public class weatherController {
    @Autowired
    GaodeWeather gaodeWeather;

    @GetMapping
    @ApiOperation("获取高德天气")
    public AjaxMessage getWeather(){
        Map<String, String> parm = new HashMap<>();
        parm.put("city", "萍乡市");
        parm.put("type", "base");
        gaodeWeather.GetWeatherByCity(parm);
        return AjaxMessage.success();
    }
}
