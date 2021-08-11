package com.nuaa.crm.settings.service;

import com.nuaa.crm.exception.LoginException;
import com.nuaa.crm.settings.domain.tb_user;

import java.util.List;

public interface UserService {


    tb_user login(String loginAct, String loginPwd, String ip) throws LoginException;

    List<tb_user> getUserList();
}
