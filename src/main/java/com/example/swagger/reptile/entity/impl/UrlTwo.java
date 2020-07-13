package com.example.swagger.reptile.entity.impl;

import com.example.swagger.reptile.entity.Url;

/**
 * @类描述:图片网站
 * @创建人:xiejs
 * @创建时间:2020-7-13 09:49:5
 */
public class UrlTwo implements Url {
    private String url="http://sc.chinaz.com/tupian/index.html";

    @Override
    public String getUrl() {
        return this.url;
    }
}
