package com.example.swagger.user.domain.bo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @创建人 xjs
 * @类描述 TODO
 * @创建时间 2020/3/15 0015 上午 10:45
 */
@ApiModel(value = "角色")
@Data
public class UserBO {
    @NotBlank(message = "账号不能为空")
    @Size(max = 25, message = "账号在25个字符之内")
    @ApiModelProperty(value = "请输入账号")
    private String userName;

    @NotBlank(message = "密码不能为空")
    @Size(max = 25, message = "密码在25个字符之内")
    @ApiModelProperty(value = "请输入密码")
    private String password;

    @NotBlank(message = "姓名不能为空")
    @Size(max = 25, message = "姓名在25个字符之内")
    @ApiModelProperty(value = "姓名")
    private String personName;

}
