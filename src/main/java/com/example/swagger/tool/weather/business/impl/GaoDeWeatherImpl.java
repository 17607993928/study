package com.example.swagger.tool.weather.business.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.swagger.common.utils.PureNetUtil;
import com.example.swagger.tool.weather.business.GaodeWeather;
import com.example.swagger.tool.weather.dao.WeatherDao;
import com.example.swagger.tool.weather.domain.WeatherPO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;

/**
 * @创建人 xjs
 * @类描述 高德天气PAI
 * @创建时间 2020/3/21 0021 下午 19:24
 */
@Service
public class GaoDeWeatherImpl implements GaodeWeather {
    @Value("${weather.key}")
    private String key;

    private static final Logger log = LoggerFactory.getLogger(GaodeWeather.class);

    @Resource
    WeatherDao weatherDao;

    @Override
    public void GetWeatherByCity(Map<String,String> parm) {
        String jsonString = excute(parm);
        JSONObject jsonObject = JSONObject.parseObject(jsonString);
        String status = (String) jsonObject.get("status");
        WeatherPO weatherPO = new WeatherPO();
        if ("1".equals(status)) {
            //base代表实况天气，获取实况天气数据
            if ("base".equals(parm.get("type"))) {
                JSONArray listObject = (JSONArray) jsonObject.get("lives");
                if (!CollectionUtils.isEmpty(listObject) && listObject.size() > 0) {
                    JSONObject normalJson = (JSONObject) listObject.get(0);
                    String province = normalJson.getString("province");
                    String city = normalJson.getString("city");
                    String adCode = normalJson.getString("adcode");
                    String weatherStatus = normalJson.getString("weather");
                    String temperature = normalJson.getString("temperature");
                    String winddirection = normalJson.getString("winddirection");
                    String windpower = normalJson.getString("windpower");
                    String humidity = normalJson.getString("humidity");
                    String reporttime = normalJson.getString("reporttime");
                    //API获取的参数
                    weatherPO.setProvince(province + "省");
                    weatherPO.setCityName(city);
                    weatherPO.setAdcode(adCode);
                    weatherPO.setWindDirection(winddirection + "风");
                    weatherPO.setWindPower(windpower);
                    weatherPO.setTemperature(temperature + "℃");
                    weatherPO.setHumidity(humidity);
                    weatherPO.setWeather(weatherStatus);
                    weatherPO.setReporttime(reporttime);
                    //其他参数
                    weatherPO.setWeatherTime(new Date());
                    weatherPO.setRemarks("高德实况天气API");
                    weatherDao.insert(weatherPO);
                }
            }
        }

    }


    private String excute(Map<String,String> parm){
        String city=parm.get("city");
        String type=parm.get("type");
        String url="https://restapi.amap.com/v3/weather/weatherInfo?key="+ key +"&city="+city+"&extensions="+type+"";
        log.info(url);
        return PureNetUtil.get(url);
    }

}
