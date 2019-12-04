package com.grq.servlet.user;

import com.grq.bean.User;
import com.grq.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/user/login")
public class LoginServlet extends HttpServlet {

	private UserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/page/user/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        userService =new UserService();
        String name=req.getParameter("username");
        String password=req.getParameter("password");
        User u=userService.userLogin(name,password);
        if(null!=u){
            //登陆成功
            HttpSession session = req.getSession();
            session.setAttribute("userId",u.getId());
            session.setAttribute("userName",u.getUsername());
            resp.sendRedirect("/");
        }else{
            //登陆失败
            req.setAttribute("msg","账号或密码错误");
            req.getRequestDispatcher("/page/user/login.jsp").forward(req,resp);
        }
    }
}
