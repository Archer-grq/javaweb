package com.grq.servlet.admin;

import com.grq.bean.dto.PduWithC;
import com.grq.service.ProductService;
import com.grq.util.ReadConfig;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/pduList")
public class ProductInfoServlet extends HttpServlet {

	private ProductService productService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        productService=new ProductService();
        List<PduWithC> productList = productService.showPdus();

        for (PduWithC p : productList) {
            p.setPimg(ReadConfig.server_upload_img_path+ReadConfig.separator +p.getPimg());
            p.setDescribe(p.getDescribe().trim().replaceAll("\r\n", " "));
        }
        req.setAttribute("pduList",productList);
        req.getRequestDispatcher("/page/admin/pduList.jsp").forward(req,resp);
    }
}
