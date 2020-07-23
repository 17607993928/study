package com.example.swagger.weather.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @类描述:天气dto
 * @创建人:xiejs
 * @创建时间:2020-7-22 09:27:18
 */
@Data
@ApiModel("天气信息DTO")
public class WeatherDTO {
    @ApiModelProperty("城市名称")
    private String cityName;         

    @ApiModelProperty("省份")
    private String province;         

    @ApiModelProperty("天气现象（汉字描述）")
    private String weather;          

    @ApiModelProperty("实时气温，单位：摄氏度")
    private String temperature;      

    @ApiModelProperty("风向描述")
    private String windDirection;    

    @ApiModelProperty("风力级别")
    private String windPower;        

    @ApiModelProperty("空气湿度")
    private String humidity;         

    @ApiModelProperty("报告时间")
    private String reporttime;
}
