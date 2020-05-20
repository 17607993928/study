package com.example.swagger.common.designPatterns.singletonPattern;

/**
 * @类描述:测试恶汉模式
 * @创建人:xiejs
 * @创建时间:2020-5-7
 */
public class testDog {

    public static void main(String[] args) {
        Dog dog = Dog.getDog();
        dog.setEat("屎");
        String eat = dog.getEat();
        System.out.println(eat);
    }
}
