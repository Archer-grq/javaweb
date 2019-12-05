package com.grq.servlet;

import com.grq.bean.Product;
import com.grq.bean.ProductClass;
import com.grq.service.ProductClassService;
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
import java.util.Map;

@WebServlet("")
public class IndexServlet extends HttpServlet {
	private ProductClassService pcs=null;
    private ProductService ps=null;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        pcs=new ProductClassService();
        ps=new ProductService();


        List<ProductClass> pcList = pcs.getAll();
        int firstPC=pcList.get(0).getId();
        Map<Integer,List<Product>> map=ps.getAllGropByClass();

        for(int i:map.keySet()){
            List<Product> pl=map.get(i);
            for(Product p:pl){
                p.setDescribe(p.getDescribe().trim().replaceAll("\r\n", " "));
                p.setPimg(ReadConfig.server_upload_img_path+ReadConfig.separator+p.getPimg());
            }
        }

        req.setAttribute("map",map);
        req.setAttribute("list",pcList);
        req.setAttribute("firstPC",firstPC);
        req.getRequestDispatcher("/page/index.jsp").forward(req,resp);
    }
}
