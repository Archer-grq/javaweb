package com.grq.service.impl;

import com.grq.bean.BaseResult;
import com.grq.bean.ShopCar;
import com.grq.dao.ShopCarDao;
import com.grq.dao.impl.ShopCarDaoImpl;
import com.grq.bean.dto.SCWithP;
import com.grq.service.ShopCarService;

import java.util.List;

public class ShopCharServiceImpl implements ShopCarService {
    private ShopCarDao shopCarDao=new ShopCarDaoImpl();
    private BaseResult<ShopCar> baseResult=null;
    @Override
    public BaseResult<ShopCar> add(ShopCar shopCar) {
        shopCarDao=new ShopCarDaoImpl();

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

    @Override
    public BaseResult<ShopCar> deleteById(int id) {
        shopCarDao=new ShopCarDaoImpl();
        int i = shopCarDao.deleteById(id);
        if(i==0){
            baseResult=new BaseResult<>(500,"商品删除失败");
        }else{
            baseResult=new BaseResult<>(200,"商品删除成功");
        }
        return baseResult;
    }

    @Override
    public BaseResult<ShopCar> deleteAll(int uid) {
        shopCarDao=new ShopCarDaoImpl();
        int i = shopCarDao.deleteAll(uid);
        if(i==0){
            baseResult=new BaseResult<>(500,"商品删除失败");
        }else{
            baseResult=new BaseResult<>(200,"商品删除成功");
        }
        return baseResult;
    }

    @Override
    public BaseResult<ShopCar> update(ShopCar shopCar) {
        shopCarDao=new ShopCarDaoImpl();
        int update = shopCarDao.update(shopCar);
        if(update==0){
            baseResult=new BaseResult<>(500,"商品更新失败");
        }else{
            baseResult=new BaseResult<>(200,"商品更新成功");
        }
        return baseResult;
    }

    @Override
    public List<ShopCar> getByUid(int uid) {
        shopCarDao=new ShopCarDaoImpl();
        return shopCarDao.getByUid(uid);
    }

    @Override
    public List<SCWithP> getSCPByUid(int uid) {
        shopCarDao=new ShopCarDaoImpl();
        return shopCarDao.getSCPByUid(uid);
    }

    @Override
    public int checkIsHave(int uid, int pid) {
        shopCarDao=new ShopCarDaoImpl();
        return shopCarDao.checkIsHave(uid, pid);
    }
}
