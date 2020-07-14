package com.example.learn.DesignPatterns.prototypePattern;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @类描述:克隆
 * @创建人:xiejs
 * @创建时间:2020-7-13 15:40:59
 */
@Data
public class Sheep implements Cloneable, Serializable {

    private String name;
    private Integer age;

    private Date date;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        //添加如下代码实现深复制
        Object obj = super.clone();
        Sheep s=(Sheep) obj;
        s.date= (Date) this.date.clone();

        return obj;
    }
}
