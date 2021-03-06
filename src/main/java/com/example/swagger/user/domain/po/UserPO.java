package com.example.swagger.user.domain.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.io.Serializable;

/**
 * @创建人 xjs
 * @类描述 角色po
 * @创建时间 2020/3/15 0015 上午 10:36
 */
@Data
@TableName("USER")
public class UserPO extends Model<UserPO> implements Serializable {
    private static final long serialVersionUID = 6270451087401009279L;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    private String userName;        //账号

    private String password;        //密码

    private Long personId;          //人员id


}
