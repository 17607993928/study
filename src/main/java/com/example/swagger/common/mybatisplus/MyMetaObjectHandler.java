package com.example.swagger.common.mybatisplus;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

/**
 * @类描述:字段自动填充
 * @创建人:xiejs
 * @创建时间:2020-5-20 18:47:27
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {

        Object password = getFieldValByName("password", metaObject);
        if(password==null){
            setFieldValByName("password","666666",metaObject);
        }

    }

    @Override
    public void updateFill(MetaObject metaObject) {

    }
}
