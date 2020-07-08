package com.example.learn.annotation.study;

import lombok.Data;

/**
 * @类描述:
 * @创建人:xiejs
 * @创建时间:
 */
@Data

@Field(columnName = "xjs",type = "ces",length = 10)
public class Student {

    @Field(columnName = "xjs",type = "ces",length = 10)
    private int id;
    private int age;
    private String name;


}
