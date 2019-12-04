package com.grq.dao.impl;

import com.grq.bean.Admin;
import com.grq.dao.AdminDao;
import com.grq.util.JdbcUtil;

import java.sql.*;

public class AdminDaoImpl implements AdminDao {

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private PreparedStatement ps;

    @Override
    public Admin getAdminByName(String name) {
        Admin admin=null;
        try {
            connection= JdbcUtil.getConnection();
            String sql="select * from admin where name =? ";
            ps=connection.prepareStatement(sql);
            ps.setString(1,name);
            resultSet=ps.executeQuery();
            admin=new Admin();
            while (resultSet.next()){
                admin.setId(resultSet.getInt("id"));
                admin.setName(resultSet.getString("name"));
                admin.setPwd(resultSet.getString("pwd"));
            }

        } catch (Exception e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }finally {
            JdbcUtil.close(resultSet,ps,connection);
        }
        if(admin==null||admin.getPwd()==null||admin.getName()==null){
            return null;
        }
        return admin;
    }
}
