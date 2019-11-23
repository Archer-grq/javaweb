package com.grq.dao;

import com.grq.bean.BaseResult;
import com.grq.bean.ShopCar;
import com.grq.dto.SCWithP;

import java.util.List;

public interface ShopCarDao {

    int add(ShopCar shopCar);
    int deleteById(int id);
    int deleteAll(int uid);
    int update(ShopCar shopCar);
    List<ShopCar> getByUid(int uid);
    List<SCWithP> getSCPByUid(int uid);
    int checkIsHave(int uid,int pid);
    ShopCar getByPU(int uid,int pid);
    int deleteByPid(int pid);
}
