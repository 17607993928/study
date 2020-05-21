package com.example.swagger.common.mybatisplus;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @类描述:自定义mapper
 * @创建人:xiejs
 * @创建时间:
 */
public interface MyBaseMapper<T> extends BaseMapper<T> {

    //自定义sql方法
    List<T> findAll();
}
