package com.example.swagger.weather.service.impl;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.swagger.weather.dao.WeatherDao;
import com.example.swagger.weather.domain.po.WeatherPO;
import com.example.swagger.weather.service.WeatherService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
    public List<WeatherPO> getWeatherByCityAndDate(String city, Date date) {
        QueryWrapper<WeatherPO> queryWrapper=new QueryWrapper();
        queryWrapper.like("city_name",city);

        //获取一天的开始到结束
        DateTime beginOfDay = DateUtil.beginOfDay(date);
        DateTime endOfDay = DateUtil.endOfDay(date);

        queryWrapper.between("reporttime",beginOfDay.toString(),endOfDay.toString());
        List<WeatherPO> weatherPOList = weatherDao.selectList(queryWrapper);
        return weatherPOList;
    }

    public static void main(String[] args) {
        Date date=new Date();
        DateTime beginOfDay = DateUtil.beginOfDay(date);
        DateTime endOfDay = DateUtil.endOfDay(date);

        String s = beginOfDay.toString();
        System.out.println(s);

    }
}
