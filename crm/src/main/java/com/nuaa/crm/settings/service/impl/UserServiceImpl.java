package com.nuaa.crm.settings.service.impl;

import com.nuaa.crm.settings.dao.UserDao;
import com.nuaa.crm.settings.domain.tb_user;
import com.nuaa.crm.settings.service.UserService;
import com.nuaa.crm.utils.SqlSessionUtil;

public class UserServiceImpl implements UserService {
    private UserDao userDao = SqlSessionUtil.getSqlSession().getMapper(UserDao.class);


    public tb_user login(String loginAct, String loginPwd, String ip) {
        return null;
    }
}
