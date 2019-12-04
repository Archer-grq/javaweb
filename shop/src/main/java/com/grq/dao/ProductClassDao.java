package com.grq.dao;

import com.grq.bean.ProductClass;
import com.grq.dao.ProductClassDao;
import com.grq.util.JdbcUtil;
import java.util.List;

public class ProductClassDao{
    
    public ProductClass getClassById(int id) {
        List<ProductClass> select = JdbcUtil.select("select * from product where id =?", new Object[]{id}, ProductClass.class);
        if(select.size()==0){
            return null;
        }else {
            return select.get(0);
        }
    }

   
    public int addClass(String cname) {
        return JdbcUtil.insert("INSERT into class (cname) values (?)", new Object[]{cname});
    }


    public List<ProductClass> getAll() {
        return JdbcUtil.select("select * from class", new Object[]{}, ProductClass.class);
    }
}
