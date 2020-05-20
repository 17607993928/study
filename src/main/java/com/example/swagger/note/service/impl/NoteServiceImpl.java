package com.example.swagger.note.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.swagger.note.dao.NoteDao;
import com.example.swagger.note.domain.po.NotePO;
import com.example.swagger.note.service.NoteService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @创建人 xjs
 * @类描述 TODO
 * @创建时间 2020/3/14 0014 下午 23:19
 */
@Service
public class NoteServiceImpl extends ServiceImpl<NoteDao, NotePO> implements NoteService {
    @Resource
    NoteDao noteDao;



}
