package com.nuaa.crm.workbench.dao;

import com.nuaa.crm.workbench.domain.Activity;

import java.util.List;
import java.util.Map;

public interface ActivityDao {
    int save(Activity a);

    List<Activity> getActivityListByCondtion(Map<String, Object> map);

    int getTotalByCondtition(Map<String, Object> map);
}
