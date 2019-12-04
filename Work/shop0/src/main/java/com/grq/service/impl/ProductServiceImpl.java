package com.grq.service.impl;

import com.grq.bean.BaseResult;
import com.grq.bean.Product;
import com.grq.bean.ShopCar;
import com.grq.dao.ProductDao;
import com.grq.dao.ShopCarDao;
import com.grq.dao.impl.ProductDaoImpl;
import com.grq.dao.impl.ShopCarDaoImpl;
import com.grq.dto.PduWithC;
import com.grq.service.ProductClassService;
import com.grq.service.ProductService;
import com.mysql.cj.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {
    ProductDao productDao=null;

    @Override
    public List<Product> getAll() {
        productDao=new ProductDaoImpl();
        return productDao.getAll();
    }

    @Override
    public Product getById(int id) {
        productDao=new ProductDaoImpl();
        return productDao.getById(id);
    }

    @Override
    public BaseResult<Product> addProduct(Product product) {

        productDao=new ProductDaoImpl();

        BaseResult<Product> baseResult=checkProduct(product);
        if(baseResult.getStatus()==200){
            int result = productDao.addProduct(product);
            if(result==1){
                baseResult.setMessage("商品添加成功");
            }else{
                baseResult.setMessage("商品添加失败");
            }
        }
        return baseResult;
    }

    @Override
    public BaseResult<Product> deleteById(int id) {
        //删除商品要同时删除所有用户购物车中包含该商品的数据
        BaseResult<Product> baseResult=null;
        productDao=new ProductDaoImpl();
        ShopCarDao shopCarDao=new ShopCarDaoImpl();
        int i = shopCarDao.deleteByPid(id);
        int i1 = productDao.deleteById(id);
        if(i!=0&&i1!=0){
            //删除成功
            baseResult=new BaseResult<>(200,"删除成功");
        }else{
            baseResult=new BaseResult<>(200,"删除失败");
        }

        return baseResult;
    }

    @Override
    public BaseResult<Product> update(Product product) {

        productDao=new ProductDaoImpl();

        return null;
    }

    @Override
    public List<PduWithC> showPdus() {
        productDao=new ProductDaoImpl();
        return productDao.getPduWithCname();
    }

    @Override
    public Map<Integer,List<Product>> getAllGropByClass() {
        productDao =new ProductDaoImpl();
        List<Product> pList=productDao.getAll();
        Map<Integer,List<Product>> map=new HashMap<>();

        List<Product> products=null;
        for(Product p:pList) {
            int cid =p.getCid();
            if(map.get(cid)==null){
                List<Product> ps =new ArrayList<>();
                map.put(cid,ps);
            }
            products=map.get(cid);
            products.add(p);
            map.put(cid,products);
        }

        return map;
    }

    public BaseResult<Product> checkProduct(Product product){
        BaseResult<Product> baseResult=null;
        if(product.getCid()==0
                ||StringUtils.isNullOrEmpty(product.getPname())
                ||Double.isNaN(product.getPvalue())
        ){
            baseResult=new BaseResult<>(500,"商品信息有误");
        }else{
            baseResult=new BaseResult<>(200,"OK");
        }
        return baseResult;
    }

}
