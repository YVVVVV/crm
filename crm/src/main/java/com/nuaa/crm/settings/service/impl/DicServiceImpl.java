package com.nuaa.crm.settings.service.impl;

import com.nuaa.crm.settings.dao.DicTypeDao;
import com.nuaa.crm.settings.dao.DicValueDao;
import com.nuaa.crm.settings.service.DicService;
import com.nuaa.crm.utils.SqlSessionUtil;

public class DicServiceImpl implements DicService {

    private DicTypeDao dicTypeDao = SqlSessionUtil.getSqlSession().getMapper(DicTypeDao.class);
    private DicValueDao dicValueDao = SqlSessionUtil.getSqlSession().getMapper(DicValueDao.class);

}
