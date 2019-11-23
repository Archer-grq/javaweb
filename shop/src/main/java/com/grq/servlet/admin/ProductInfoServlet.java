package com.grq.servlet.admin;

import com.grq.bean.Product;
import com.grq.dto.PduWithC;
import com.grq.service.ProductService;
import com.grq.service.impl.ProductServiceImpl;
import com.grq.util.StaticString;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/pduList")
public class ProductInfoServlet extends HttpServlet {

    private ProductService productService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        productService=new ProductServiceImpl();
        List<PduWithC> productList = productService.showPdus();

        for (PduWithC p : productList) {
            p.setPimg(StaticString.IMG_PATH+p.getPimg());
            p.setDescribe(p.getDescribe().trim().replaceAll("\r\n", " "));
        }
        req.setAttribute("pduList",productList);
        req.getRequestDispatcher("/page/admin/pduList.jsp").forward(req,resp);
    }
}
