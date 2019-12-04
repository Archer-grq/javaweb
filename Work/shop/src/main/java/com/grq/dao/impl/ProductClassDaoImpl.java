package com.grq.dao.impl;

import com.grq.bean.ProductClass;
import com.grq.dao.ProductClassDao;
import com.grq.util.JdbcUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductClassDaoImpl implements ProductClassDao {
    @Override
    public ProductClass getClassById(int id) {
        List<ProductClass> select = JdbcUtil.select("select * from product where id =?", new Object[]{id}, ProductClass.class);
        if(select.size()==0){
            return null;
        }else {
            return select.get(0);
        }
    }

    @Override
    public int addClass(String cname) {
        return JdbcUtil.insert("INSERT into class (cname) values (?)", new Object[]{cname});
    }


    @Override
    public List<ProductClass> getAll() {
        return JdbcUtil.select("select * from class", new Object[]{}, ProductClass.class);
    }
}
