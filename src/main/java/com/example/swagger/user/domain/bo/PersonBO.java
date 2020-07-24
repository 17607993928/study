package com.example.swagger.user.domain.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @类描述:人员po
 * @创建人:xiejs
 * @创建时间:2020-7-23 13:48:35
 */
@Data
@ApiModel("人员BO")
public class PersonBO implements Serializable {
    private static final long serialVersionUID = 6270451087411009279L;

    @ApiModelProperty("人名")
    private String personName;           

    @ApiModelProperty("性别")
    private Integer sex;

    @ApiModelProperty("电话")
    private String telephone;            

    @ApiModelProperty("电子邮箱")
    private String email;

    @ApiModelProperty("描述")
    private String description;          

}
