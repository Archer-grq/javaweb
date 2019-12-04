package com.grq.servlet.admin;

import com.grq.service.UserService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/delete")
public class UserDeleteServlet extends HttpServlet {


	@Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService=new UserService();
        int id =Integer.parseInt(req.getParameter("id"));
        int i=userService.deleteUser(id);
        if(i==1){
            //删除成功
            req.setAttribute("dmessage","删除成功");
            req.getRequestDispatcher("/admin/userInfo").forward(req,resp);
        }else {
            //删除失败
            req.setAttribute("dmessage","删除失败");
            req.getRequestDispatcher("/admin/userInfo").forward(req,resp);
        }
    }
}
