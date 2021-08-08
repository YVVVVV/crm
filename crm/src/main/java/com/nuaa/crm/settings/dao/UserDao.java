package com.nuaa.crm.settings.dao;

import com.nuaa.crm.settings.domain.tb_user;

import java.util.Map;

public interface UserDao {
    tb_user login(Map<String, String> map);
}
