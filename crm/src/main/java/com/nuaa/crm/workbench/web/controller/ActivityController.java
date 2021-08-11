package com.nuaa.crm.workbench.web.controller;

import com.nuaa.crm.settings.domain.tb_user;
import com.nuaa.crm.settings.service.UserService;
import com.nuaa.crm.settings.service.impl.UserServiceImpl;
import com.nuaa.crm.utils.*;
import com.nuaa.crm.vo.PaginationVO;
import com.nuaa.crm.workbench.domain.Activity;
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

public class ActivityController extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response) throws SecurityException, ServletException, IOException {
        System.out.println("进入控制器222");
        String path = request.getServletPath();
        if("/workbench/activity/getUserList.do".equals(path)){
            getUserList(request,response);

        }else if("/workbench/activity/save.do".equals(path)){
            save(request,response);
                 String id = UUIDUtil.getUUID();
                 String owner = request.getParameter("owner");
                 String name = request.getParameter("name");
                 String startdate = request.getParameter("startdate");
                 String enddate = request.getParameter("enddate");
                 String cost = request.getParameter("cost");
                 String description = request.getParameter("description");

                 String createtime = DateTimeUtil.getSysTime();
                 String createby = ((tb_user) request.getSession().getAttribute("user")).getName();

                Activity a =new Activity();
                a.setId(id);
                a.setOwner(owner);
                a.setName(name);
                a.setStartdate(startdate);
                a.setEnddate(enddate);
                a.setCost(cost);
                a.setDescription(description);
                a.setCreatetime(createtime);
                a.setCreateby(createby);

                 ActivityService as = (ActivityService) ServiceFactory.getService(new ActivityServiceImpl());

                boolean flag = as.save(a);
                PrintJson.printJsonFlag(response,flag);
        }else if("/workbench/activity/pageList.do".equals(path)){

            System.out.println("进入查询");
            String name = request.getParameter("name");
            String owner = request.getParameter("owner");
            String startdate = request.getParameter("startdate");
            String enddate = request.getParameter("enddate");
            String pageNoStr = request.getParameter("pageNo");

            int pageNo=Integer.valueOf(pageNoStr);

            String pageSizeStr = request.getParameter("pageSize");

            int pageSize=Integer.valueOf(pageSizeStr);
                //略过记录数
            int skipCount = (pageNo-1)*pageSize;
            pageSize+=skipCount;
            pageSize+=1;

            Map<String,Object>map = new HashMap<String,Object>();
            map.put("name",name);
            map.put("owner",owner);
            map.put("startdate",startdate);
            map.put("enddate",enddate);
            map.put("skipCount",skipCount);
            map.put("pageSize",pageSize);

            ActivityService as = (ActivityService) ServiceFactory.getService(new ActivityServiceImpl());

            PaginationVO<Activity> vo= as.pageList(map);
            PrintJson.printJsonObj(response,vo);

        }

    }

    private void save(HttpServletRequest request, HttpServletResponse response) {

        System.out.println("执行市场活动添加");

    }

    private void getUserList(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("取得用户信息列表");
        UserService us = (UserService) ServiceFactory.getService(new UserServiceImpl());

        List<tb_user> userList = us.getUserList();
        PrintJson.printJsonObj(response,userList);

    }


}
