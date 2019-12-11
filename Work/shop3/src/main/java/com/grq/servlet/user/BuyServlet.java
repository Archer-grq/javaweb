package com.grq.servlet.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.grq.bean.BaseResult;
import com.grq.bean.ShopCar;
import com.grq.service.ShopCarService;

@WebServlet("/user/buy")
public class BuyServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		ShopCarService shopCarService=new ShopCarService();
		int uid=(Integer)session.getAttribute("userId");
		List<ShopCar> list=shopCarService.getByUid(uid);
		if(list.size()==0) {
			req.setAttribute("msg", "您的购物车为空，无法购买！！！");
		}else {
			BaseResult<ShopCar> result=shopCarService.deleteAll(uid);
			if(result.getStatus()==200) {
				req.setAttribute("msg", "购买成功！！！");
			}else {
				req.setAttribute("msg", "购买失败！！！");
			}
		}
		req.getRequestDispatcher("/page/user/successBuy.jsp").forward(req, resp);
	}

}
