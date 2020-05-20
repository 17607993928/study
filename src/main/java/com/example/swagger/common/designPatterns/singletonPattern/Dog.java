package com.example.swagger.common.designPatterns.singletonPattern;

/**
 * @类描述:饿汉模式
 * @创建人:xiejs
 * @创建时间:2020-5-7
 */
public class Dog {
    private String eat;

    public String getEat() {
        return eat;
    }

    public void setEat(String eat) {
        this.eat = eat;
    }

    //构建对象
    private static Dog dog=new Dog();

    //私有化构造器
    private Dog(){
    }

    //提供公用的访问接口
    public static Dog getDog(){
        return dog;
    }

}
