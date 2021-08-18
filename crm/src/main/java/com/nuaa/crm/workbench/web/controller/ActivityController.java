package com.nuaa.crm.workbench.web.controller;

import com.nuaa.crm.settings.domain.tb_user;
import com.nuaa.crm.settings.service.UserService;
import com.nuaa.crm.settings.service.impl.UserServiceImpl;
import com.nuaa.crm.utils.*;
import com.nuaa.crm.vo.PaginationVO;
import com.nuaa.crm.workbench.domain.Activity;
import com.nuaa.crm.workbench.domain.ActivityRemark;
import com.nuaa.crm.workbench.service.ActivityService;
import com.nuaa.crm.workbench.service.impl.ActivityServiceImpl;
import org.apache.ibatis.annotations.Update;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActivityController extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进入控制器222");
        String path = request.getServletPath();
        if("/workbench/activity/getUserList.do".equals(path)){
            
            getUserList(request,response);

        }else if("/workbench/activity/save.do".equals(path)){
            save(request,response);

        }else if("/workbench/activity/pageList.do".equals(path)){

            pageList(request,response);

        }else if("/workbench/activity/delete.do".equals(path)){

            delete(request,response);

        }else if("/workbench/activity/getUserListAndActivity.do".equals(path)){

            getUserListAndActivity(request,response);

        }else if("/workbench/activity/update.do".equals(path)){

            update(request,response);

        }else if("/workbench/activity/detail.do".equals(path)){

            detail(request,response);

        }else if("/workbench/activity/getRemarkListByAid.do".equals(path)){

            getRemarkListByAid(request,response);

        }else if("/workbench/activity/deleteRemark.do".equals(path)){

            deleteRemark(request,response);

        }else if("/workbench/activity/saveRemark.do".equals(path)){

            saveRemark(request,response);

        }
        else if("/workbench/activity/updateRemark.do".equals(path)){

            updateRemark(request,response);

        }

    }

    private void updateRemark(HttpServletRequest request, HttpServletResponse response) {

        System.out.println("修改备注");

        String notecontent=request.getParameter("notecontent");

        String id = request.getParameter("id");

        String edittime = DateTimeUtil.getSysTime();
        String editby = ((tb_user) request.getSession().getAttribute("user")).getName();

        String editflag = "1";

        ActivityRemark ar = new ActivityRemark();

        ar.setNotecontent(notecontent);
        ar.setId(id);
        ar.setEdittime(edittime);
        ar.setEditby(editby);
        ar.setEditflag(editflag);

        ActivityService as = (ActivityService) ServiceFactory.getService(new ActivityServiceImpl());

        boolean flag = as.updateRemark(ar);

        Map<String,Object>map = new HashMap<String, Object>();
        map.put("success",flag);
        map.put("ar",ar);

        PrintJson.printJsonObj(response,map);

    }

    private void saveRemark(HttpServletRequest request, HttpServletResponse response) {

        System.out.println("添加备注");

        String notecontent=request.getParameter("notecontent");

        String activityId = request.getParameter("activityid");
        String id=UUIDUtil.getUUID();

        String createtime = DateTimeUtil.getSysTime();
        String createBy = ((tb_user) request.getSession().getAttribute("user")).getName();
        String editflag = "0";

        ActivityRemark ar = new ActivityRemark();
        ar.setNotecontent(notecontent);
        ar.setActivityid(activityId);
        ar.setId(id);
        ar.setCreatetime(createtime);
        ar.setCreateby(createBy);
        ar.setEditflag(editflag);

        ActivityService as = (ActivityService) ServiceFactory.getService(new ActivityServiceImpl());

        boolean flag = as.saveRemark(ar);

        Map<String,Object>map = new HashMap<String, Object>();
        map.put("success",flag);
        map.put("ar",ar);

        PrintJson.printJsonObj(response,map);

    }

    private void deleteRemark(HttpServletRequest request, HttpServletResponse response) {

        System.out.println("删除备注");

        String activityId = request.getParameter("id");

        ActivityService as = (ActivityService) ServiceFactory.getService(new ActivityServiceImpl());

        boolean flag = as.deleteRemark(activityId);

        PrintJson.printJsonFlag(response,flag);



    }

    private void getRemarkListByAid(HttpServletRequest request, HttpServletResponse response) {

        System.out.println("根据市场活动填备注");

        String activityId = request.getParameter("activityId");

        ActivityService as = (ActivityService) ServiceFactory.getService(new ActivityServiceImpl());

        List<ActivityRemark> arlist = as.getRemarkListByAid(activityId);

        PrintJson.printJsonObj(response,arlist);

    }

    private void detail(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

        System.out.println("进入到详情");

        String id = request.getParameter("id");

        ActivityService as = (ActivityService) ServiceFactory.getService(new ActivityServiceImpl());

        Activity a = as.detail(id);


        request.setAttribute("a",a);

        request.getRequestDispatcher("/workbench/activity/detail.jsp").forward(request,response);
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {

        System.out.println("更新记录");
        String id = request.getParameter("id");
        String owner = request.getParameter("owner");
        String name = request.getParameter("name");
        String startdate = request.getParameter("startdate");
        String enddate = request.getParameter("enddate");
        String cost = request.getParameter("cost");
        String description = request.getParameter("description");



        String edittime = DateTimeUtil.getSysTime();
        String editby = ((tb_user) request.getSession().getAttribute("user")).getName();

        Activity a =new Activity();
        a.setId(id);
        a.setOwner(owner);
        a.setName(name);
        a.setStartdate(startdate);
        a.setEnddate(enddate);
        a.setCost(cost);
        a.setDescription(description);
        a.setEdittime(edittime);
        a.setEditby(editby);


        System.out.println(a.getName());



        ActivityService as = (ActivityService) ServiceFactory.getService(new ActivityServiceImpl());

        boolean flag = as.update(a);
        PrintJson.printJsonFlag(response,flag);

    }

    private void pageList(HttpServletRequest request, HttpServletResponse response) {
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

    private void getUserListAndActivity(HttpServletRequest request, HttpServletResponse response) {

        System.out.println("查询用户及单条记录");
        String id =request.getParameter("id");
        ActivityService as = (ActivityService) ServiceFactory.getService(new ActivityServiceImpl());

        Map<String,Object> map = as.getUserListAndActivity(id);
        PrintJson.printJsonObj(response,map);
    }

    private void delete(HttpServletRequest request,HttpServletResponse response){

        System.out.println("delete");
        String ids[] = request.getParameterValues("id");
        ActivityService as = (ActivityService) ServiceFactory.getService(new ActivityServiceImpl());

        boolean flag = as.delete(ids);
         PrintJson.printJsonFlag(response,flag);

    }

    private void save(HttpServletRequest request, HttpServletResponse response) {

        System.out.println("执行市场活动添加");
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

    }

    private void getUserList(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("取得用户信息列表");
        UserService us = (UserService) ServiceFactory.getService(new UserServiceImpl());

        List<tb_user> userList = us.getUserList();
        PrintJson.printJsonObj(response,userList);

    }


}
