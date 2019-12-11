package com.grq.servlet.admin;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = {"/admin/main","/admin/"})
public class MainServlet extends HttpServlet {


	@Override
    protected void service( HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/page/admin/main.jsp").forward(req,resp);
    }

}
