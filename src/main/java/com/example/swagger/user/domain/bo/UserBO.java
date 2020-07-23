package com.example.swagger.user.domain.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @类描述:角色bo
 * @创建人:xiejs
 * @创建时间:2020-7-23 13:54:53
 */
@Data
@ApiModel("角色bo")
public class UserBO implements Serializable {
    private static final long serialVersionUID = 6270421087411009279L;

    @ApiModelProperty(value = "账号")
    private String userName;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty("用户对象")
    private PersonBO personBO;
}
