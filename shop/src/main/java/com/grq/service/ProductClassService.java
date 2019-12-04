package com.grq.service;

import com.grq.bean.BaseResult;
import com.grq.bean.Product;
import com.grq.bean.ProductClass;
import com.grq.dao.ProductClassDao;
import com.grq.service.ProductClassService;

import java.util.List;

public class ProductClassService{
    ProductClassDao productClassDao=null;
    public ProductClassService() {
    	productClassDao=new ProductClassDao();
    }
   
    public List<ProductClass> getAll() {
        return productClassDao.getAll();
    }

  
    public Product getById(int id) {
        return null;
    }

    
    public BaseResult<Product> addOne(String name) {
        return null;
    }
}
