package com.grq.servlet.admin;

import com.grq.bean.Admin;
import com.grq.service.AdminService;
import com.grq.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/admin/login")
public class AdminLoginServlet extends HttpServlet {

    private AdminService adminService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/page/admin/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        adminService =new AdminServiceImpl();

        String name=req.getParameter("name");
        String password=req.getParameter("pwd");
        Admin admin=adminService.adminLogin(name,password);

        if(null!=admin){
            //登陆成功
            HttpSession session = req.getSession();
            session.setAttribute("adminName",admin.getName());
            resp.sendRedirect("/page/admin/main.jsp");
        }else{
            resp.sendRedirect("/page/admin/login.jsp");
        }

    }
}
