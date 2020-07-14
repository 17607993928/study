package com.example.learn.DesignPatterns.FactoryPattern.AbstractFactory;

/**
 * @创建人 xjs
 * @类描述 TODO
 * @创建时间 2020/7/12 0012 上午 0:06
 */
public class GoodPhoneFactory implements PhoneFactory {
    @Override
    public SanXing createSanXIng() {
        return new Note9SanXing();
    }

    @Override
    public XiaoMi createXiaoMi() {
        return new Mi10XiaoMi();
    }
}
