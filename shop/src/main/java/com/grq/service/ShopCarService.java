package com.grq.service;

import com.grq.bean.BaseResult;
import com.grq.bean.ShopCar;
import com.grq.dto.SCWithP;

import java.util.List;

public interface ShopCarService {

    BaseResult<ShopCar>add(ShopCar shopCar);
    BaseResult<ShopCar>deleteById(int id);
    BaseResult<ShopCar>deleteAll(int uid);
    BaseResult<ShopCar>update(ShopCar shopCar);
    List<ShopCar> getByUid(int uid);
    List<SCWithP> getSCPByUid(int uid);
    int checkIsHave(int uid,int pid);

}
