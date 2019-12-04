package com.grq.servlet;

import com.grq.bean.Product;
import com.grq.service.ProductService;
import com.grq.util.StaticString;
import com.mysql.cj.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {
	private ProductService productService=null;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        productService=new ProductService();
        String pid1 = req.getParameter("pid");
        if(StringUtils.isNullOrEmpty(pid1)){
            resp.sendRedirect("/");
        }
        int pid=Integer.parseInt(pid1);
        Product p = productService.getById(pid);

        if(p==null){
            resp.sendRedirect("/");
        }else{
            p.setPimg(StaticString.IMG_PATH+p.getPimg());
            p.setDescribe(p.getDescribe().trim().replaceAll("\r\n", " "));
            req.setAttribute("product",p);
            req.getRequestDispatcher("/page/product.jsp").forward(req,resp);
        }
    }
}
