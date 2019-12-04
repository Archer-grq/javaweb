package com.grq.service;

import com.grq.bean.BaseResult;
import com.grq.bean.Product;
import com.grq.bean.dto.PduWithC;

import java.util.List;
import java.util.Map;

public interface ProductService {
    List<Product> getAll();
    Product getById(int id);
    BaseResult<Product> addProduct(Product product);
    BaseResult<Product>deleteById(int id);
    BaseResult<Product>update(Product product);
    List<PduWithC> showPdus();
    Map<Integer,List<Product>> getAllGropByClass();
}
