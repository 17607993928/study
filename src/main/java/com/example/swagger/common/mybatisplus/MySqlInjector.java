package com.example.swagger.common.mybatisplus;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;

import java.util.List;

/**
 * @类描述:mybatisplus注入sql
 * @创建人:xiejs
 * @创建时间:2020-5-20 18:18:02
 */
public class MySqlInjector extends DefaultSqlInjector {
    @Override
    public List<AbstractMethod> getMethodList() {
        List<AbstractMethod> methodList = super.getMethodList();

        methodList.add(new FindAll());

        return methodList;
    }
}
