package com.grq.service;

import com.grq.bean.BaseResult;
import com.grq.bean.Product;
import com.grq.bean.ProductClass;

import java.util.List;

public interface ProductClassService {

    List<ProductClass> getAll();
    Product getById(int id);
    BaseResult<Product> addOne(String name);

}
