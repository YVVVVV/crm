package com.nuaa.crm.settings.web.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserController extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response) throws SecurityException, ServletException, IOException {
        System.out.println("进入控制器");
        String path = request.getServletPath();
        if("/settings/user/xxx.do".equals(path)){


        }else if("/settings/user/xxx.do".equals(path)){


        }
    }


}
