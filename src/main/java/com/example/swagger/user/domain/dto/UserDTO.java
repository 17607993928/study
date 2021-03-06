package com.example.swagger.user.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * @创建人 xjs
 * @类描述 TODO
 * @创建时间 2020/3/15 0015 上午 10:45
 */
@Data
public class UserDTO {
    @ApiModelProperty(value = "账号")
    private String userName;

    @ApiModelProperty(value = "密码")
    private String password;

}
