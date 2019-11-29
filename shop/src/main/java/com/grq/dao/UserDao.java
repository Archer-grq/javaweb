package com.grq.dao;

import com.grq.bean.User;

import java.util.List;

public interface UserDao {

    User getUserById(Integer id);

    User getUserByName(String name);

    int userReg(String name,String password);

    List<User> selectAll();

    int userDeleteByID(int id);

    int update(int id,String password);
}
