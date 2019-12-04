package com.grq.service.impl;

import com.grq.bean.BaseResult;
import com.grq.bean.User;
import com.grq.dao.UserDao;
import com.grq.dao.impl.UserDaoImpl;
import com.grq.service.UserService;
import com.mysql.cj.util.StringUtils;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserServiceImpl() {
        this.userDao = new UserDaoImpl();
    }

    /**
     *
     * @param name 账号
     * @param password 密码
     * @return 成功返回 user对象,失败则返回空
     */
    @Override
    public User userLogin(String name,String password) {

        if(!StringUtils.isNullOrEmpty(name) &&!StringUtils.isNullOrEmpty(password)){
            User dbUser=userDao.getUserByName(name);
            if(null!=dbUser){
                if(password.equals(dbUser.getPassword())){
                    return dbUser;
                }
            }
        }
        return null;
    }

    @Override
    public BaseResult<User> userReg(String name, String password) {
        BaseResult<User> baseResult=null;
        int value=0;
        if(!StringUtils.isNullOrEmpty(name) &&!StringUtils.isNullOrEmpty(password)){
            User dbUser=userDao.getUserByName(name);
            if(dbUser==null){
                value=userDao.userReg(name, password);
                if(value==0){
                    baseResult=new BaseResult<User>(500,"账号注册失败");
                }else{
                    baseResult=new BaseResult<User>(200,"注册成功");
                }
            }else {
                baseResult=new BaseResult<User>(500,"账号名已存在，请更换账号名");
            }
        }else {
            baseResult=new BaseResult<User>(500,"注册失败");
        }
        return baseResult;
    }

    @Override
    public List<User> selectAll() {
        return userDao.selectAll();
    }

    @Override
    public int deleteUser(int id) {
        return userDao.userDeleteByID(id);
    }

    @Override
    public int update(int id, String password) {
        return userDao.update(id,password);
    }

}
