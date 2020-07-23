package com.example.swagger.weather.service.impl;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.swagger.weather.dao.WeatherDao;
import com.example.swagger.weather.domain.dto.WeatherDTO;
import com.example.swagger.weather.domain.po.WeatherPO;
import com.example.swagger.weather.service.WeatherService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @类描述:
 * @创建人:xiejs
 * @创建时间:
 */
@Service
public class WeatherServiceImpl extends ServiceImpl<WeatherDao, WeatherPO> implements WeatherService {
    @Resource
    private WeatherDao weatherDao;


    @Override
    public List<WeatherDTO> getWeatherByCityAndDate(String city, Date date) {
        QueryWrapper<WeatherPO> queryWrapper=new QueryWrapper();
        queryWrapper.like("city_name",city);
        //去重
        queryWrapper.select("DISTINCT reporttime,city_name,province,weather ,temperature ,wind_direction ,wind_power ,humidity");
        //排序
        queryWrapper.orderByAsc("reporttime");

        //获取一天的开始到结束
        DateTime beginOfDay = DateUtil.beginOfDay(date);
        DateTime endOfDay = DateUtil.endOfDay(date);

        queryWrapper.between("reporttime",beginOfDay.toString(),endOfDay.toString());
        List<WeatherPO> weatherPOList = weatherDao.selectList(queryWrapper);
        List<WeatherDTO> weatherDTOList=new ArrayList<>();
        weatherPOList.forEach(weatherPO -> {
            WeatherDTO weatherDTO = poToDto(weatherPO);
            weatherDTOList.add(weatherDTO);
        });
        return weatherDTOList;
    }

    private WeatherDTO poToDto(WeatherPO weatherPO){
        WeatherDTO weatherDTO=new WeatherDTO();
        BeanUtils.copyProperties(weatherPO,weatherDTO);
        return weatherDTO;
    }


}
