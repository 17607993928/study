package com.example.swagger.common.mybatisplus;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;

/**
 * @类描述:findAll方法
 * @创建人:xiejs
 * @创建时间:2020-5-20 18:32:14
 */
public class FindAll extends AbstractMethod {

    @Override
    public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo) {
        String sqlMethod="findAll";
        String sql="SELECT * FROM" + tableInfo.getTableName();

        SqlSource sqlSource=languageDriver.createSqlSource(configuration,sql,modelClass);
        return this.addSelectMappedStatement(mapperClass,sqlMethod,sqlSource,modelClass,tableInfo);
    }
}
