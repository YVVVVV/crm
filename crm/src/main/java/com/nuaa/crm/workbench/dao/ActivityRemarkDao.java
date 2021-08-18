package com.nuaa.crm.workbench.dao;

import com.nuaa.crm.workbench.domain.ActivityRemark;

import java.util.List;

public interface ActivityRemarkDao {
    int getCountByAdis(String[] ids);

    int deleteByAdis(String[] ids);

    List<ActivityRemark> getRemarkListByAid(String activityId);

    int deleteRemark(String activityId);

    int saveRemark(ActivityRemark ar);

    int updateRemark(ActivityRemark ar);
}
