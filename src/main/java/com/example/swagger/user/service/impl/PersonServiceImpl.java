package com.example.swagger.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.swagger.user.dao.PersonDao;
import com.example.swagger.user.domain.po.PersonPO;
import com.example.swagger.user.service.PersonService;
import org.springframework.stereotype.Service;

/**
 * @类描述:
 * @创建人:xiejs
 * @创建时间:
 */
@Service
public class PersonServiceImpl extends ServiceImpl<PersonDao, PersonPO> implements PersonService {
}
