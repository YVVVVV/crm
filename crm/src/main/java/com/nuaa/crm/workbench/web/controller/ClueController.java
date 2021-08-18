package com.nuaa.crm.workbench.web.controller;

import com.nuaa.crm.settings.domain.tb_user;
import com.nuaa.crm.settings.service.UserService;
import com.nuaa.crm.settings.service.impl.UserServiceImpl;
import com.nuaa.crm.utils.DateTimeUtil;
import com.nuaa.crm.utils.PrintJson;
import com.nuaa.crm.utils.ServiceFactory;
import com.nuaa.crm.utils.UUIDUtil;
import com.nuaa.crm.vo.PaginationVO;
import com.nuaa.crm.workbench.domain.Activity;
import com.nuaa.crm.workbench.domain.ActivityRemark;
import com.nuaa.crm.workbench.service.ActivityService;
import com.nuaa.crm.workbench.service.impl.ActivityServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClueController extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进入控制器-线索");
        String path = request.getServletPath();
        if ("/workbench/clue/getUserList.do".equals(path)) {

//            getUserList(request, response);

        } else if ("/workbench/clue/save.do".equals(path)) {
//            save(request, response);

        }

    }

}
