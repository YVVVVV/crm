package com.nuaa.crm.settings.service.impl;

import com.nuaa.crm.exception.LoginException;
import com.nuaa.crm.settings.dao.UserDao;
import com.nuaa.crm.settings.domain.tb_user;
import com.nuaa.crm.settings.service.UserService;
import com.nuaa.crm.utils.DateTimeUtil;
import com.nuaa.crm.utils.SqlSessionUtil;

import java.util.HashMap;
import java.util.Map;

public class UserServiceImpl implements UserService {
    private UserDao userDao = SqlSessionUtil.getSqlSession().getMapper(UserDao.class);


    public tb_user login(String loginAct, String loginPwd, String ip) throws LoginException {
        Map<String,String> map = new HashMap<String,String>();
        map.put("loginAct",loginAct);
        map.put("loginPwd",loginPwd);
        tb_user user = userDao.login(map);

        if(user==null){

            throw new LoginException("账号密码错误");

        }
        String expireTime = user.getExpiretime();
        String currentTime = DateTimeUtil.getSysTime();
        if(expireTime.compareTo(currentTime)<0){

            throw new LoginException("账号失效");
        }
        String lockState = user.getLockstate();
        if("0".equals(lockState)){

            throw new LoginException("账号锁定");
        }
        String allowIps = user.getAllowips();
        //if(allowIps!=null && "")
        if(!allowIps.contains(ip)){

            throw new LoginException("地址受限");
        }
        return user;
    }
}
