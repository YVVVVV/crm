package com.nuaa.crm.workbench.service.impl;

import com.nuaa.crm.utils.SqlSessionUtil;
import com.nuaa.crm.workbench.dao.ClueDao;
import com.nuaa.crm.workbench.service.ClueService;

public class ClueServiceImpl implements ClueService {

    private ClueDao clueDao = SqlSessionUtil.getSqlSession().getMapper(ClueDao.class);

}
