package com.grq.servlet.admin;

import com.grq.bean.BaseResult;
import com.grq.bean.Product;
import com.grq.service.ProductService;
import com.grq.util.ReadConfig;

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
        productService=new ProductService();
        int id=Integer.parseInt(req.getParameter("id"));
        Product p = productService.getById(id);
        String img =p.getPimg();
        BaseResult<Product> baseResult = productService.deleteById(id);
        if(baseResult.getStatus()==200){
            File file=new File(ReadConfig.program_img_path+ReadConfig.separator+img);
            if(file.exists()&&file.isFile()){
                file.delete();
            }
            File file1=new File(req.getServletContext().getRealPath(ReadConfig.server_upload_img_path)+ReadConfig.separator+img);
            if(file1.exists()&&file1.isFile()){
                file1.delete();
            }
        }
        resp.sendRedirect("/admin/pduList");

    }
}
