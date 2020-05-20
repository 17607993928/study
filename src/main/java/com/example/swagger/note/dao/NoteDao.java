package com.example.swagger.note.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.swagger.note.domain.po.NotePO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @创建人 xjs
 * @类描述 TODO
 * @创建时间 2020/3/14 0014 下午 23:17
 */
@Mapper
public interface NoteDao extends BaseMapper<NotePO> {
}
