package com.grq.servlet.user;

import com.grq.bean.BaseResult;
import com.grq.bean.ShopCar;
import com.grq.bean.dto.SC;
import com.grq.bean.dto.SCWithP;
import com.grq.service.ShopCarService;
import com.grq.util.ReadConfig;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/user/shopcar")
public class ShopCarServlet extends HttpServlet {
 
	ShopCarService shopCarService=null;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        shopCarService=new ShopCarService();
        HttpSession session=req.getSession();
        Integer userId = (Integer)session.getAttribute("userId");

        List<SC> list = shopCarService.getSCAll(userId);
        double totalMoney=0;
        for(SC scWithP :list){
            scWithP.setPimg(ReadConfig.server_upload_img_path+ReadConfig.separator+scWithP.getPimg());
            totalMoney+=scWithP.getNum()* scWithP.getPvalue();
        }
        req.setAttribute("list",list);
        req.setAttribute("totalMoney",totalMoney);
        req.getRequestDispatcher("/page/user/shopcar.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        shopCarService=new ShopCarService();
        int uid=Integer.parseInt(req.getParameter("uid"));
        int pid=Integer.parseInt(req.getParameter("pid"));
        String strNum=req.getParameter("pnum");
        int num=0;
        String msg=null;
        try {
            num=Integer.parseInt(strNum);
        }catch (Exception e){
            msg="数量中只能包含数字！";
            req.setAttribute("msg",msg);
            req.getRequestDispatcher("/product?pid="+pid).forward(req,resp);
        }
        if(msg==null){
            if(num>9999){
                msg="单次购买数量不能超过9999";
                req.setAttribute("msg",msg);
                req.getRequestDispatcher("/product?pid="+pid).forward(req,resp);

            }else if(num<=0){
                msg="购买数量不能小于或等于0";
                req.setAttribute("msg",msg);
                req.getRequestDispatcher("/product?pid="+pid).forward(req,resp);
            }
            else {
                ShopCar shopCar=new ShopCar(uid,pid,num);
                BaseResult<ShopCar> baseResult = shopCarService.add(shopCar);
                if(baseResult.getStatus()==200){
                    resp.sendRedirect("/user/shopcar");
                }else{
                    msg=baseResult.getMessage();
                    req.setAttribute("msg",msg);
                    req.getRequestDispatcher("/product?pid="+pid).forward(req,resp);
                }
            }
        }

    }
}
