package com.example.swagger.note.controller;

import com.example.swagger.note.domain.po.NotePO;
import com.example.swagger.note.service.NoteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/note")
@Api(tags = {"笔记管理"})
public class NoteController {
    @Autowired
    NoteService noteService;




    @PostMapping
    @ApiOperation(value = "新增保养计划", notes = "新增保养计划及其附属信息")
    public String save(NotePO notePO){
        noteService.save(notePO);
        return "xxx";
    }

    @GetMapping("/test")
    public String test(){
        return "下乡阿萨法萨芬";
    }
}
