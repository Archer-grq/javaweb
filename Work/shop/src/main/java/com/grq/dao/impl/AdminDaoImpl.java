package com.grq.dao.impl;

import com.grq.bean.Admin;
import com.grq.dao.AdminDao;
import com.grq.util.JdbcUtil;

import java.sql.*;
import java.util.List;

public class AdminDaoImpl implements AdminDao {

    @Override
    public Admin getAdminByName(String name) {

        List<Admin> select = JdbcUtil.select("select * from admin where name =?", new Object[]{name}, Admin.class);
        if(select.size()==0){
            return null;
        }else {
            return select.get(0);
        }
    }
}
