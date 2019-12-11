package com.grq.filter;

import com.mysql.cj.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/admin/*","/admin","/page/admin/*"})
public class AdminFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req=(HttpServletRequest)request;
        HttpServletResponse resp=(HttpServletResponse) response;
        //设置请求编码格式
        req.setCharacterEncoding("utf-8");
        //设置响应编码格式
        resp.setContentType("text/html;charset=utf-8");
        String uri=req.getRequestURI();
        if(uri.endsWith("login")||uri.endsWith("login.jsp")){
            chain.doFilter(request,response);
        }else{
            HttpSession session=req.getSession();
            String name =(String)session.getAttribute("adminName");
            if(StringUtils.isNullOrEmpty(name)){
                resp.sendRedirect("/admin/login");
            }else{
                chain.doFilter(request,response);
            }
        }


    }

    @Override
    public void destroy() {

    }
}
