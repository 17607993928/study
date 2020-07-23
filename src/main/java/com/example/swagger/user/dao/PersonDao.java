package com.example.swagger.user.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.swagger.user.domain.po.PersonPO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @类描述:人员dao
 * @创建人:xiejs
 * @创建时间:2020-7-23 14:03:25
 */
@Mapper
public interface PersonDao extends BaseMapper<PersonPO> {
}
