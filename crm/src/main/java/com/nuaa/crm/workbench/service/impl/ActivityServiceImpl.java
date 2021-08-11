package com.nuaa.crm.workbench.service.impl;

import com.nuaa.crm.utils.SqlSessionUtil;
import com.nuaa.crm.vo.PaginationVO;
import com.nuaa.crm.workbench.dao.ActivityDao;
import com.nuaa.crm.workbench.domain.Activity;
import com.nuaa.crm.workbench.service.ActivityService;

import java.util.List;
import java.util.Map;

public class ActivityServiceImpl implements ActivityService {
    private ActivityDao activityDao = SqlSessionUtil.getSqlSession().getMapper(ActivityDao.class);

    public boolean save(Activity a) {
        boolean flag = true;
        int count = activityDao.save(a);
        if(count!=1){

            flag = false;
        }
        return false;
    }

    public PaginationVO<Activity> pageList(Map<String, Object> map) {

        int total = activityDao.getTotalByCondtition(map);
        List<Activity>dataList = activityDao.getActivityListByCondtion(map);

        PaginationVO<Activity> vo = new PaginationVO<Activity>();
        vo.setDataList(dataList);
        vo.setTotal(total);

        return vo;
    }
}
