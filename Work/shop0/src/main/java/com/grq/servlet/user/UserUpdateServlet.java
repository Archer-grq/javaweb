package com.grq.servlet.user;

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

@WebServlet("/user/update")
public class UserUpdateServlet extends HttpServlet {
    private UserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/page/user/update.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        userService=new UserServiceImpl();

        //获取表单信息
        int id=Integer.parseInt(req.getParameter("id").trim());
        String name = req.getParameter("name").trim();
        String oldPassword = req.getParameter("oldPassword").trim();
        String newPassword = req.getParameter("newPassword").trim();
        String newPassword1 = req.getParameter("newPassword1").trim();

        if(StringUtils.isNullOrEmpty(name)||StringUtils.isNullOrEmpty(newPassword)||StringUtils.isNullOrEmpty(oldPassword)||StringUtils.isNullOrEmpty(newPassword1)){
            //密码格式不正确
            req.setAttribute("msg", "密码格式不正确");
            req.getRequestDispatcher("/page/user/update.jsp").forward(req, resp);

        }else {

            User user = userService.userLogin(name, oldPassword);
            //判断原密码是否正确
            if (user == null) {
                //原密码不正确
                req.setAttribute("msg", "原密码错误！请重新输入");
                req.getRequestDispatcher("/page/user/update.jsp").forward(req, resp);
            } else {
                //原密码正确
                //判断两次新密码输入是否一致
                if (!newPassword.equals(newPassword1)) {
                    //不一致
                    req.setAttribute("msg", "两次密码不一致");
                    req.getRequestDispatcher("/page/user/update.jsp").forward(req, resp);
                } else {
                    //一致
                    int update = userService.update(id, newPassword);
                    if (update == 0) {
                        //更新失败
                        req.setAttribute("msg", "更新失败");
                        req.getRequestDispatcher("/page/user/update.jsp").forward(req, resp);
                    } else {
                        //更新成功
                        req.setAttribute("message", "更新成功");
                        req.getRequestDispatcher("/page/user/update.jsp").forward(req, resp);
                    }
                }

            }
        }
    }
}
