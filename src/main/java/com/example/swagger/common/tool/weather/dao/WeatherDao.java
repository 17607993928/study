package com.example.swagger.common.tool.weather.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.swagger.common.tool.weather.domain.WeatherPO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @创建人 xjs
 * @类描述 TODO
 * @创建时间 2020/4/10 0010 下午 21:12
 */
@Mapper
public interface WeatherDao extends BaseMapper<WeatherPO> {

}
