package com.example.swagger.user.domain.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.swagger.user.enums.SexEnum;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.io.Serializable;

/**
 * @类描述:人员po
 * @创建人:xiejs
 * @创建时间:2020-7-23 13:48:35
 */
@Data
@TableName("person")
public class PersonPO implements Serializable {
    private static final long serialVersionUID = 6270451087411009279L;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    private String personName;          //人名

    private String personCode;          //人员code

    private SexEnum sex;                   //性别

    private String telephone;           //电话

    @TableField(value = "e_mail")
    private String email;               //电子邮箱

    private String description;         //描述

}
