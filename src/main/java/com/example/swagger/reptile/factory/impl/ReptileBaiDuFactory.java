package com.example.swagger.reptile.factory.impl;

import com.example.swagger.reptile.entity.impl.UrlOne;
import com.example.swagger.reptile.factory.ReptileFactory;

/**
 * @类描述:
 * @创建人:xiejs
 * @创建时间:
 */
public class ReptileBaiDuFactory implements ReptileFactory {

    @Override
    public UrlOne createUrl() {
        return new UrlOne();
    }
}
