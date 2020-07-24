package com.example.swagger.weather.controller;

import com.example.swagger.common.utils.AjaxMessage;
import com.example.swagger.common.utils.DateUtil;
import com.example.swagger.weather.domain.dto.WeatherDTO;
import com.example.swagger.weather.manager.GaodeWeather;
import com.example.swagger.weather.service.WeatherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @创建人 xjs
 * @类描述
 * @创建时间 2020/4/10 0010 下午 21:53
 */
@RestController
@Api(tags = {"高德天气"})
@RequestMapping("/weather")
public class WeatherController {
    @Autowired
    GaodeWeather gaodeWeather;
    @Autowired
    WeatherService weatherService;

    @GetMapping
    @ApiOperation("获取高德天气")
    public AjaxMessage getWeather(String city){
        Map<String, String> parm = new HashMap<>();
        parm.put("city", city);
        parm.put("type", "base");
        gaodeWeather.GetWeatherByCity(parm);
        return AjaxMessage.success();
    }

    @GetMapping("getWeather")
    @ApiOperation("根据城市日期获取天气")
    public AjaxMessage getWeatherByCityAndDate(String city, String date){
        Date stringToDate=null;
        if(date.contains("-")){
           stringToDate = DateUtil.StringToDate(date, DateUtil.DATE_FORMAT_TIME_T);
        }else if(date.contains("/")){
            stringToDate=DateUtil.StringToDate(date,"MM/dd/yyyy");
        }
        List<WeatherDTO> weatherDTOList = weatherService.getWeatherByCityAndDate(city, stringToDate);
        for (WeatherDTO weatherDTO : weatherDTOList) {
            String reporttime = weatherDTO.getReporttime();
            Date toDate = DateUtil.StringToDate(reporttime, DateUtil.DATE_FORMAT_TIME_T);
            String dateToString = DateUtil.dateToString(toDate, "HH:mm");
            weatherDTO.setReporttime(dateToString);

            //字符串中获取数字
            String temperature = weatherDTO.getTemperature();
            String regEx="[^0-9]";
            Pattern p = Pattern.compile(regEx);
            Matcher m = p.matcher(temperature);
            weatherDTO.setTemperature( m.replaceAll("").trim());
        }
        return AjaxMessage.success().data(weatherDTOList);
    }
}
