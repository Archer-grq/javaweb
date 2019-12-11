package com.grq.service;

import com.grq.bean.BaseResult;
import com.grq.bean.ShopCar;
import com.grq.dao.ShopCarDao;
import com.grq.bean.dto.SCWithP;

import java.util.List;

public class ShopCarService{
    private ShopCarDao shopCarDao=null;
    private BaseResult<ShopCar> baseResult=null;
    
    public ShopCarService() {
    	shopCarDao=new ShopCarDao();
    }
    
    public BaseResult<ShopCar> add(ShopCar shopCar) {

        int i = shopCarDao.checkIsHave(shopCar.getUid(), shopCar.getPid());
        if(i==0){
            //没有该商品
            int value = shopCarDao.add(shopCar);
            if(value==0){
                baseResult=new BaseResult<>(500,"添加到购物车失败");
            }else {
                baseResult=new BaseResult<>(200,"添加到购物车成功");
            }
        }else{
            //已有该商品
            ShopCar shopCar1=shopCarDao.getByPU(shopCar.getUid(), shopCar.getPid());
            shopCar1.setPnum(shopCar.getPnum()+shopCar1.getPnum());
            int update = shopCarDao.update(shopCar1);
            if(update==0){
                baseResult=new BaseResult<>(500,"添加到购物车失败");
            }else {
                baseResult=new BaseResult<>(200,"添加到购物车成功");
            }
        }
        return baseResult;
    }

   
    public BaseResult<ShopCar> deleteById(int id) {
        int i = shopCarDao.deleteById(id);
        if(i==0){
            baseResult=new BaseResult<>(500,"商品删除失败");
        }else{
            baseResult=new BaseResult<>(200,"商品删除成功");
        }
        return baseResult;
    }

   
    public BaseResult<ShopCar> deleteAll(int uid) {
        int i = shopCarDao.deleteAll(uid);
        if(i==0){
            baseResult=new BaseResult<>(500,"商品删除失败");
        }else{
            baseResult=new BaseResult<>(200,"商品删除成功");
        }
        return baseResult;
    }

    
    public BaseResult<ShopCar> update(ShopCar shopCar) {
        int update = shopCarDao.update(shopCar);
        if(update==0){
            baseResult=new BaseResult<>(500,"商品更新失败");
        }else{
            baseResult=new BaseResult<>(200,"商品更新成功");
        }
        return baseResult;
    }

   
    public List<ShopCar> getByUid(int uid) {
        return shopCarDao.getByUid(uid);
    }

   
    public List<SCWithP> getSCPByUid(int uid) {
        return shopCarDao.getSCPByUid(uid);
    }

   
    public int checkIsHave(int uid, int pid) {
        return shopCarDao.checkIsHave(uid, pid);
    }
}
