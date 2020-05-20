package com.example.swagger.common.tool.weather.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @创建人 xjs
 * @类描述 TODO
 * @创建时间 2020/3/22 0022 上午 11:55
 */
@Data
@TableName(value = "weather")
public class WeatherPO {
    private static final long serialVersionUID = -4485246724632807664L;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    private String adcode;        //城市编码

    private String cityName;        //城市名称

    private String province;        //省份

    private String weather;         //天气现象（汉字描述）

    private String temperature;     //实时气温，单位：摄氏度

    private String windDirection;   //风向描述

    private String windPower;       //风力级别

    private String humidity;        //空气湿度

    private String reporttime;      //数据发布时间

    private String remarks;         //备注

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date weatherTime;       //添加时间
}
