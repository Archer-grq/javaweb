package com.grq.servlet.user;

import com.grq.bean.BaseResult;
import com.grq.bean.ShopCar;
import com.grq.service.ShopCarService;
import com.grq.service.impl.ShopCharServiceImpl;
import com.mysql.cj.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/user/shopcar/delete")
public class ShopCarDeleteServlet extends HttpServlet {
    private ShopCarService shopCarService =null;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        shopCarService=new ShopCharServiceImpl();
        HttpSession session=req.getSession();
        int userid=(Integer)session.getAttribute("userId");

        String id = req.getParameter("id");
        if(StringUtils.isNullOrEmpty(id)){
            BaseResult<ShopCar> baseResult = shopCarService.deleteAll(userid);
            resp.sendRedirect("/user/shopcar");
        }else{
            int sid=Integer.parseInt(id);
            BaseResult<ShopCar> baseResult = shopCarService.deleteById(sid);
            resp.sendRedirect("/user/shopcar");
        }


    }
}
