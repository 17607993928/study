package com.example.learn.DesignPatterns.FactoryPattern.AbstractFactory;

/**
 * @创建人 xjs
 * @类描述 TODO
 * @创建时间 2020/7/12 0012 上午 0:03
 */
public class Test {
    public static void main(String[] args) {
        PhoneFactory factory=new GoodPhoneFactory();

        SanXing sanXIng = factory.createSanXIng();
        XiaoMi xiaoMi = factory.createXiaoMi();

        sanXIng.doSMS();
        xiaoMi.callPhone();
        xiaoMi.playGame();


    }
}
