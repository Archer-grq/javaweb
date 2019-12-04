package com.grq.dao.impl;

import com.grq.bean.ProductClass;
import com.grq.dao.ProductClassDao;
import com.grq.util.JdbcUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductClassDaoImpl implements ProductClassDao {
    private Connection connection;
    private ResultSet resultSet;
    private PreparedStatement ps;
    @Override
    public ProductClass getClassById(int id) {
       ProductClass productClass=null;
        try {
            connection= JdbcUtil.getConnection();
            String sql="select * from product where id =?";
            ps=connection.prepareStatement(sql);
            ps.setInt(1,id);
            resultSet=ps.executeQuery();
            while (resultSet.next()){
                productClass=new ProductClass();
                productClass.setId(resultSet.getInt("id"));
                productClass.setCname("cname");
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
        return productClass;
    }

    @Override
    public int addClass(String cname) {
        int value=0;
        try {
            connection= JdbcUtil.getConnection();
            String sql="INSERT into class (cname) values (?)";
            ps=connection.prepareStatement(sql);
            ps.setString(1,cname);
            value=ps.executeUpdate();

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
        return value;
    }


    @Override
    public List<ProductClass> getAll() {
        List<ProductClass> list=new ArrayList<>();
        ProductClass productClass=null;
        try {
            connection= JdbcUtil.getConnection();
            String sql="select * from class";
            ps=connection.prepareStatement(sql);
            resultSet=ps.executeQuery();
            while (resultSet.next()){
               productClass =new ProductClass();
               productClass.setCname(resultSet.getString("cname"));
               productClass.setId(resultSet.getInt("id"));
               list.add(productClass);
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
        return list;
    }
}
