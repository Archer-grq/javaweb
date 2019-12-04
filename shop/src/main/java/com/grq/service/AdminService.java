package com.grq.service;

import com.grq.bean.Admin;
import com.grq.dao.AdminDao;
import com.grq.service.AdminService;
import com.mysql.cj.util.StringUtils;

public class AdminService {
    private AdminDao adminDao;
    public AdminService() {
    	adminDao =new AdminDao();
    }
  
    public Admin adminLogin(String name, String pwd) {
        
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
