package com.grq.dao;

import com.grq.bean.ProductClass;

import java.util.List;

public interface ProductClassDao {

    ProductClass getClassById(int id);
    int addClass(String cname);
    List<ProductClass> getAll();


}
