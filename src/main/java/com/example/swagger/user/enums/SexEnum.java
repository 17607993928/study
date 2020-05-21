package com.example.swagger.user.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;

/**
 * @类描述:枚举
 * @创建人:xiejs
 * @创建时间:2020-5-20 19:44:57
 */
public enum  SexEnum implements IEnum<Integer> {
    MAN(1,"男"),

    WOMAN(1,"女");

    private int value;
    private String desc;

    SexEnum(int value, String desc) {
        this.value=value;
        this.desc=desc;
    }


    @Override
    public Integer getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
