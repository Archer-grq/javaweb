package com.grq.service.impl;

import com.grq.bean.Admin;
import com.grq.dao.AdminDao;
import com.grq.dao.impl.AdminDaoImpl;
import com.grq.service.AdminService;
import com.mysql.cj.util.StringUtils;

public class AdminServiceImpl implements AdminService {
    private AdminDao adminDao;
    @Override
    public Admin adminLogin(String name, String pwd) {
        adminDao =new AdminDaoImpl();
        if(!StringUtils.isNullOrEmpty(name) &&!StringUtils.isNullOrEmpty(pwd)){
            Admin admin=adminDao.getAdminByName(name);
            if(null!=admin){
                if(pwd.equals(admin.getPwd())){
                    return admin;
                }
            }
        }
        return null;

    }
}
