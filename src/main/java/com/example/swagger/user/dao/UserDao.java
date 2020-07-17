package com.example.swagger.user.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.swagger.user.domain.po.UserPO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @类描述:用户dao
 * @创建人:xiejs
 * @创建时间:2020-7-17 13:13:30
 */
@Mapper
public interface UserDao extends BaseMapper<UserPO> {
}
