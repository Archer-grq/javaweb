package com.grq.dao;

import com.grq.bean.User;
import com.grq.dao.UserDao;
import com.grq.util.JdbcUtil;

import java.util.List;

public class UserDao {

     
    public User getUserById(Integer id) {
        List<User> list = JdbcUtil.select("select * from user where id =?", new Object[]{id}, User.class);
        if(list.size()==0){
            return null;
        }else {
            return list.get(0);
        }
    }

     
    public User getUserByName(String name) {
        List<User> list = JdbcUtil.select("select * from user where username =?", new Object[]{name}, User.class);
        if(list.size()==0){
            return null;
        }else {
            return list.get(0);
        }
    }

     
    public int userReg(String name, String password) {
       return JdbcUtil.insert("insert into user (username,password)values (?,?)", new Object[]{name, password});
    }

     
    public List<User> selectAll() {
        return JdbcUtil.selectALL(User.class);
    }

     
    public int userDeleteByID(int id) {
        return JdbcUtil.delete("delete from user where id=?", new Object[]{id});
    }

     
    public int update(int id, String password) {
        return JdbcUtil.update("update user set password=? where id =?", new Object[]{password, id});
    }


}
