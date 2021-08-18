package com.nuaa.crm.workbench.service.impl;

import com.nuaa.crm.settings.dao.UserDao;
import com.nuaa.crm.settings.domain.tb_user;
import com.nuaa.crm.utils.SqlSessionUtil;
import com.nuaa.crm.vo.PaginationVO;
import com.nuaa.crm.workbench.dao.ActivityDao;
import com.nuaa.crm.workbench.dao.ActivityRemarkDao;
import com.nuaa.crm.workbench.domain.Activity;
import com.nuaa.crm.workbench.domain.ActivityRemark;
import com.nuaa.crm.workbench.service.ActivityService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActivityServiceImpl implements ActivityService {
    private ActivityDao activityDao = SqlSessionUtil.getSqlSession().getMapper(ActivityDao.class);
    private ActivityRemarkDao activityRemarkDao = SqlSessionUtil.getSqlSession().getMapper(ActivityRemarkDao.class);
    private UserDao userDao = SqlSessionUtil.getSqlSession().getMapper(UserDao.class);
    public boolean save(Activity a) {
        boolean flag = true;
        int count = activityDao.save(a);
        if(count!=1){

            flag = false;
        }
        return flag;
    }

    public PaginationVO<Activity> pageList(Map<String, Object> map) {

        int total = activityDao.getTotalByCondtition(map);
        List<Activity>dataList = activityDao.getActivityListByCondtion(map);

        PaginationVO<Activity> vo = new PaginationVO<Activity>();
        vo.setDataList(dataList);
        vo.setTotal(total);

        return vo;
    }

    public boolean delete(String[] ids) {

        boolean flag = true;
        int count = activityRemarkDao.getCountByAdis(ids);
        int count2 = activityRemarkDao.deleteByAdis(ids);

        if(count!=count2){
            flag = false;
        }
        int count3 = activityDao.delete(ids);

        if(count3!=ids.length){

            flag = false;

        }
        return flag;
    }

    public Map<String, Object> getUserListAndActivity(String id) {

        List<tb_user> ulist = userDao.getUserList();

        Activity a = activityDao.getById(id);

       Map<String,Object> map = new HashMap<String, Object>();
       map.put("uList",ulist);
       map.put("a",a);
       return map;
    }


    public boolean update(Activity a) {

        boolean flag = true;
        int count = activityDao.update(a);
        if(count!=1){

            flag = false;
        }
        return flag;

    }

    public Activity detail(String id) {

        Activity a = activityDao.detail(id);

        return a;
    }

    public List<ActivityRemark> getRemarkListByAid(String activityId) {

        List<ActivityRemark> arlist = activityRemarkDao.getRemarkListByAid(activityId);

        return arlist;
    }

    public boolean deleteRemark(String activityId) {

        boolean flag=true;

        int count = activityRemarkDao.deleteRemark(activityId);

        if(count!=1){

            flag = false;

        }

        return flag;
    }

    public boolean saveRemark(ActivityRemark ar) {

        boolean flag=true;

        int count = activityRemarkDao.saveRemark(ar);

        if(count!=1){

            flag = false;

        }

        return flag;
    }

    public boolean updateRemark(ActivityRemark ar) {
        boolean flag=true;

        int count = activityRemarkDao.updateRemark(ar);

        if(count!=1){

            flag = false;

        }

        return flag;
    }


}
