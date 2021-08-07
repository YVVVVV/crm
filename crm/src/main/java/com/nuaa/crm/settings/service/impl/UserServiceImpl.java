package com.nuaa.crm.settings.service.impl;

import com.nuaa.crm.settings.dao.UserDao;
import com.nuaa.crm.settings.service.UserSerice;
import com.nuaa.crm.utils.SqlSessionUtil;

public class UserServiceImpl implements UserSerice {
    private UserDao userDao = SqlSessionUtil.getSqlSession().getMapper(UserDao.class);


}
