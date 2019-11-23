package com.grq.service.impl;

import com.grq.bean.BaseResult;
import com.grq.bean.Product;
import com.grq.bean.ProductClass;
import com.grq.dao.ProductClassDao;
import com.grq.dao.impl.ProductClassDaoImpl;
import com.grq.service.ProductClassService;

import java.util.List;

public class ProductClassServiceImpl implements ProductClassService {
    ProductClassDao productClassDao=null;
    @Override
    public List<ProductClass> getAll() {
        productClassDao=new ProductClassDaoImpl();
        return productClassDao.getAll();
    }

    @Override
    public Product getById(int id) {
        return null;
    }

    @Override
    public BaseResult<Product> addOne(String name) {
        return null;
    }
}
