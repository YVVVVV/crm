package com.nuaa.crm.settings.web.controller;

import com.nuaa.crm.settings.domain.tb_user;
import com.nuaa.crm.settings.service.UserService;
import com.nuaa.crm.settings.service.impl.UserServiceImpl;
import com.nuaa.crm.utils.MD5Util;
import com.nuaa.crm.utils.PrintJson;
import com.nuaa.crm.utils.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UserController extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response) throws SecurityException, ServletException, IOException {
        System.out.println("进入控制器111");
        String path = request.getServletPath();
        if("/settings/user/login.do".equals(path)){


        }else if("/settings/user/login.do".equals(path)){


        }

    }

    private void login(HttpServletRequest request,HttpServletResponse response){
        System.out.println("验证12312 ");
        String loginAct = request.getParameter("loginAct");
        String loginPwd = request.getParameter("loginPwd");
        loginPwd= MD5Util.getMD5(loginPwd);
        String ip = request.getRemoteAddr();
        System.out.println("-------------"+ip);
        UserService userService = (UserService) ServiceFactory.getService( new UserServiceImpl());
        try {

            tb_user user = userService.login(loginAct,loginPwd,ip);
            request.getSession().setAttribute("user",user);
            PrintJson.printJsonFlag(response,true);

        }catch (Exception e){
            e.printStackTrace();
            String msg = e.getMessage();
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("success",false);
            map.put("msg",msg);
            PrintJson.printJsonObj(response,map);
        }
    }
}
