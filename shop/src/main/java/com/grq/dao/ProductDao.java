package com.grq.dao;

import com.grq.bean.Product;
import com.grq.dao.ProductDao;
import com.grq.bean.dto.PduWithC;
import com.grq.util.JdbcUtil;

import java.util.List;

public class ProductDao{

   
    public List<Product> getAll() {
        return JdbcUtil.selectALL(Product.class);
    }

   
    public Product getById(int id) {
        List<Product> select = JdbcUtil.select("select * from product where id =?", new Object[]{id}, Product.class);
        if(select.size()==0){
            return null;
        }else {
            return select.get(0);
        }
    }

    public int addProduct(Product product) {
        return JdbcUtil.insert("insert into product (pname,pvalue,cid,`describe`,pimg)values(?,?,?,?,?)"
                ,new Object[]{
                        product.getPname(),
                        product.getPvalue(),
                        product.getCid(),
                        product.getDescribe(),
                        product.getPimg()
                });
    }

    public int deleteById(int id) {
        return JdbcUtil.delete("delete from product where id=?", new Object[]{id});
    }

    public int update(Product product) {
        return JdbcUtil.update("UPDATE product set pname=?,pvalue=?,cid=?,`describe`=?,pimg=? where id =?"
                , new Object[]{
                        product.getPname(),
                        product.getPvalue(),
                        product.getCid(),
                        product.getDescribe(),
                        product.getPimg(),
                        product.getId()
                });
    }

    public List<PduWithC> getPduWithCname() {
        return JdbcUtil.select("select p.id ,p.pname,p.pvalue,p.pimg,c.cname, p.`describe`FROM product AS p LEFT JOIN class AS c ON p.cid=c.id"
                , new Object[]{}
                , PduWithC.class);
    }

}
