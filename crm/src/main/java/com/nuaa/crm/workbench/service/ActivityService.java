package com.nuaa.crm.workbench.service;

import com.nuaa.crm.vo.PaginationVO;
import com.nuaa.crm.workbench.domain.Activity;

import java.util.Map;

public interface ActivityService {
    boolean save(Activity a);

    PaginationVO<Activity> pageList(Map<String, Object> map);
}
