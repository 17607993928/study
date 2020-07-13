package com.example.swagger.reptile.controller;

import com.example.swagger.common.utils.AjaxMessage;
import com.example.swagger.reptile.service.ReptileService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * @类描述:爬虫controller
 * @创建人:xiejs
 * @创建时间:2020-7-13 10:06:06
 */
@RestController
@Api("爬虫")
public class ReptileController {
    @Autowired
    ReptileService reptileService;

    @GetMapping("getImg")
    public AjaxMessage getImg(String url){
        List<String> imgList=null;
        try {
            imgList = reptileService.getImg(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return AjaxMessage.success().data(imgList);
    }
}
