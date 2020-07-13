package com.example.swagger.reptile.entity.impl;

import com.example.swagger.reptile.entity.Url;
import lombok.Data;

/**
 * @类描述:第一个网址
 * @创建人:xiejs
 * @创建时间:2020-7-13 09:06:19
 */
@Data
public class UrlOne implements Url {
    private String url="https://www.baidu.com";

    @Override
    public String getUrl() {
        return this.url;
    }
}
