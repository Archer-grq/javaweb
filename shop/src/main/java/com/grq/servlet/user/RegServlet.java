package com.grq.servlet.user;

import com.grq.bean.BaseResult;
import com.grq.bean.User;
import com.grq.service.UserService;
import com.grq.service.impl.UserServiceImpl;
import com.mysql.cj.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/reg")
public class RegServlet extends HttpServlet {

    private UserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/page/user/reg.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求编码格式
        req.setCharacterEncoding("utf-8");
        //设置响应编码格式
        resp.setContentType("text/html;charset=utf-8");
        System.out.println();
        userService=new UserServiceImpl();
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        if(StringUtils.isNullOrEmpty(username)||StringUtils.isNullOrEmpty(password)){

            req.setAttribute("message","账号或密码格式不对");
            req.getRequestDispatcher("/page/reg.jsp").forward(req,resp);
        }else {
            BaseResult<User> baseResult=userService.userReg(username,password);
            req.setAttribute("message",baseResult.getMessage());
            if(baseResult.getStatus()==200){
                //注册成功
                req.getRequestDispatcher("/page/user/login.jsp").forward(req,resp);
            }else {
                //注册失败
                req.getRequestDispatcher("/page/user/reg.jsp").forward(req,resp);
            }
        }

    }
}
