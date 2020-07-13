package com.example.swagger.reptile.service;

import java.io.IOException;
import java.util.List;

/**
 * @类描述:爬虫service
 * @创建人:xiejs
 * @创建时间:2020-7-13 09:13:54
 */
public interface ReptileService {

    /**
     * 获取图片路径数组
     * @param url
     * @return List
     * @throws IOException
     */
    List<String> getImg(String url) throws IOException;

    /**
     * 根据url保存图片到本地
     * @param imgList
     */
    void saveImgFile(List<String> imgList) throws IOException;


}
