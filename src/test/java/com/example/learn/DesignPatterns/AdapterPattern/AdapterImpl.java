package com.example.learn.DesignPatterns.AdapterPattern;

/**
 * @创建人 xjs
 * @类描述 适配器处理
 * @创建时间 2020/7/18 0018 下午 17:09
 */
public class AdapterImpl extends Adpatee implements Adapter {

    @Override
    public void handle() {
        super.request();
    }
}
