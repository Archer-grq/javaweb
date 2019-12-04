package com.grq.servlet.admin;


import com.grq.bean.BaseResult;
import com.grq.bean.Product;
import com.grq.bean.ProductClass;
import com.grq.service.ProductClassService;
import com.grq.service.ProductService;
import com.grq.service.impl.ProductClassServiceImpl;
import com.grq.service.impl.ProductServiceImpl;
import com.grq.util.FileIO;
import com.grq.util.StaticString;
import com.mysql.cj.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.util.List;
import java.util.UUID;

@MultipartConfig
@WebServlet("/admin/product/add")
public class ProductAddServlet extends HttpServlet {
    private ProductService productService=null;
    private ProductClassService productClassService=null;



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        productClassService=new ProductClassServiceImpl();
        String msg =req.getParameter("msg");
        if(!StringUtils.isNullOrEmpty(msg)){
            req.setAttribute("msg",msg);
        }
        List<ProductClass> cList = productClassService.getAll();
        req.setAttribute("cList",cList);
        req.getRequestDispatcher("/page/admin/addProduct.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        productService =new ProductServiceImpl();
        String strPvalue=req.getParameter("pvalue");
        String describe=req.getParameter("describe").trim().replaceAll("\r\n", " ");
        String pname=req.getParameter("pname");
        double pvalue=0;
        boolean flag=true;
        try {
            pvalue=Double.parseDouble(strPvalue);
        }catch (Exception e){
            flag=false;
            resp.sendRedirect("/admin/product/add?msg=500");
        }

        if(flag){
            if(!StringUtils.isNullOrEmpty(pname)){
                int cid= Integer.parseInt(req.getParameter("cid"));
                //获得服务器目录
                String serverpath = req.getServletContext().getRealPath(StaticString.UPLOAD_FILE);
                //如果存储图片的文件夹不存在则创建
                File path = new File(serverpath);
                if (!path.exists()){
                    path.mkdir();
                }
                //获取文件
                Part img = req.getPart("img");
                //文件名
                String imgName=img.getSubmittedFileName();
                if(!StringUtils.isNullOrEmpty(imgName)){
                    //文件名不等于空（有文件上传）
                    //文件后缀
                    String suffix = imgName.substring(imgName.lastIndexOf("."));
                    //随机的生存一个32的字符串
                    String filename = UUID.randomUUID()+suffix;
                    String filePath = serverpath+File.separator+filename;
                    //写入文件
                    img.write(filePath);
					
                    //写到项目里一份
                    try {
                        FileIO.fileIO(serverpath,filename,StaticString.programImgPath,filename);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
					
                    Product product =new Product(pname,pvalue,filename,cid,describe);
                    BaseResult<Product> baseResult = productService.addProduct(product);
                    if(baseResult.getStatus()==200){
                        //成功
                        resp.sendRedirect("/admin/product/add?msg=200");
                    }else{
                        //失败
                        resp.sendRedirect("/admin/product/add?msg=500");
                    }
                }else {
                    //没有上传图片
                    resp.sendRedirect("/admin/product/add?msg=500");
                }
            }else{//商品名称为空
                resp.sendRedirect("/admin/product/add?msg=500");
            }
        }



    }



}
