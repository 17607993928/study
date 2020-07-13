package com.example.swagger.reptile.factory.impl;

import com.example.swagger.reptile.entity.Url;
import com.example.swagger.reptile.entity.impl.UrlTwo;
import com.example.swagger.reptile.factory.ReptileFactory;

/**
 * @类描述:
 * @创建人:xiejs
 * @创建时间:
 */
public class ReptilePhotoFactory implements ReptileFactory {
    @Override
    public Url createUrl() {
        return new UrlTwo();
    }
}
