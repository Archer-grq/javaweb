package com.grq.servlet.admin;

import com.grq.bean.User;
import com.grq.service.UserService;
import com.grq.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/userInfo")
public class UserInfoServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserService userService=new UserServiceImpl();
       List<User> userList =userService.selectAll();
       if(userList!=null){
           req.setAttribute("userList",userList);
       }
        req.getRequestDispatcher("/page/admin/userInfo.jsp").forward(req,resp);
    }
}
