package com.nuaa.crm.web.filter;


import com.nuaa.crm.settings.domain.tb_user;
import jdk.nashorn.internal.ir.RuntimeNode;
import sun.misc.Request;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("登入过滤器");
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse rep = (HttpServletResponse) servletResponse;

        String path =  req.getServletPath();
        if("/login.jsp".equals(path)||"/settings/user/login.do".equals(path)){

            filterChain.doFilter(servletRequest,servletResponse);

        }else{

            HttpSession session = req.getSession();
            tb_user user = (tb_user)session.getAttribute("user");

            if(user!=null){
                filterChain.doFilter(servletRequest,servletResponse);

            }else{
                rep.sendRedirect(req.getContextPath()+"/login.jsp");

            }

        }


    }
}
