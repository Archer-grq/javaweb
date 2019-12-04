package com.grq.service;

import com.grq.bean.BaseResult;
import com.grq.bean.User;

import java.util.List;

public interface UserService {

    User userLogin(String name,String password);

    BaseResult<User> userReg(String name, String password);

    List<User> selectAll();

    int deleteUser(int id);

    int update(int id,String password);

}
