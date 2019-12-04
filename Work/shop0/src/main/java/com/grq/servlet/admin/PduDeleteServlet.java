package com.grq.servlet.admin;

import com.grq.bean.BaseResult;
import com.grq.bean.Product;
import com.grq.service.ProductService;
import com.grq.service.impl.ProductServiceImpl;
import com.grq.util.StaticString;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebServlet("/admin/pdu/delete")
public class PduDeleteServlet extends HttpServlet {
    private ProductService productService=null;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        productService=new ProductServiceImpl();
        int id=Integer.parseInt(req.getParameter("id"));
        Product p = productService.getById(id);
        String img =p.getPimg();
        BaseResult<Product> baseResult = productService.deleteById(id);
        if(baseResult.getStatus()==200){
            File file=new File(StaticString.programPath+StaticString.UPLOAD_FILE+File.separator+img);
            if(file.exists()&&file.isFile()){
                boolean delete = file.delete();
            }
            File file1=new File(req.getServletContext().getRealPath(StaticString.UPLOAD_FILE)+File.separator+img);
            if(file1.exists()&&file1.isFile()){
                boolean delete = file1.delete();
            }
        }
        resp.sendRedirect("/admin/pduList");

    }
}
