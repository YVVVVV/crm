package com.nuaa.crm.settings.service;

import com.nuaa.crm.settings.domain.tb_user;

public interface UserService {


    tb_user login(String loginAct, String loginPwd, String ip);
}
