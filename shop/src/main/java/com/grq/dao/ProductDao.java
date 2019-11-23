package com.grq.dao;

import com.grq.bean.Product;
import com.grq.dto.PduWithC;

import java.util.List;

public interface ProductDao {

    List<Product> getAll();

    Product getById(int id);

    int addProduct(Product product);

    int deleteById(int id);

    int update(Product product);

    List<PduWithC> getPduWithCname();

}
