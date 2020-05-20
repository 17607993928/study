package com.example.swagger.note.domain.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description 日记po
 * @Author  xjs
 * @Date 2019-12-20 
 */
@Data
@TableName("NOTE")
public class NotePO implements Serializable {
	private static final long serialVersionUID = -429294666980160477L;
	private Long id;	// 主键

	private String theme;	// 主题

	private String content;	// 内容

	private Date upDate;   //发布时间

	private Date createTime;	// 创建时间

	private String createUser;	// 创建人

	private Long createId;	// 创建人id



}
