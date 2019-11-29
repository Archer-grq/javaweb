package com.grq.dao.impl;

import com.grq.bean.User;
import com.grq.dao.UserDao;
import com.grq.util.JdbcUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private PreparedStatement ps;

    @Override
    public User getUserById(Integer id) {
        User u=null;
        try {
            connection= JdbcUtil.getConnection();
            String sql="select * from user where id ="+id;
            statement=connection.createStatement();
            resultSet=statement.executeQuery(sql);

            u =new User();
            while (resultSet.next()){
                u.setId(resultSet.getInt("id"));
                u.setUsername(resultSet.getString("username"));
                u.setPassword(resultSet.getString("password"));
            }

        } catch (Exception e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }finally {
            JdbcUtil.close(resultSet,statement,connection);
        }
            return u;
    }

    @Override
    public User getUserByName(String name) {
        User u=null;
        try {
            connection= JdbcUtil.getConnection();
            String sql="select * from user where username =? ";
            ps=connection.prepareStatement(sql);
            ps.setString(1,name);
            resultSet=ps.executeQuery();
            u =new User();
            while (resultSet.next()){
                u.setId(resultSet.getInt("id"));
                u.setUsername(resultSet.getString("username"));
                u.setPassword(resultSet.getString("password"));
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
        if(u==null||u.getId()==null||u.getPassword()==null||u.getUsername()==null){
            return null;
        }
        return u;
    }

    @Override
    public int userReg(String name, String password) {
        int value=0;
        try {
            connection= JdbcUtil.getConnection();
            String sql="insert into user (username,password)values (?,?)";
            ps=connection.prepareStatement(sql);
            ps.setString(1,name);
            ps.setString(2,password);
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
    public List<User> selectAll() {
        List<User> list=new ArrayList<>();
        User u=null;
        try {
            connection= JdbcUtil.getConnection();
            String sql="select * from user";
            ps=connection.prepareStatement(sql);
            resultSet=ps.executeQuery();
            while (resultSet.next()){
                u =new User();
                u.setId(resultSet.getInt("id"));
                u.setUsername(resultSet.getString("username"));
                u.setPassword(resultSet.getString("password"));
                list.add(u);
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

    @Override
    public int userDeleteByID(int id) {
        int value=0;
        try {
            connection= JdbcUtil.getConnection();
            String sql="delete from user where id=?";
            ps=connection.prepareStatement(sql);
            ps.setInt(1,id);
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
    public int update(int id, String password) {
        int value=0;
        try {
            connection= JdbcUtil.getConnection();
            String sql="update user set password=? where id =?";
            ps=connection.prepareStatement(sql);
            ps.setString(1,password);
            ps.setInt(2,id);

            value=ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }finally {
            JdbcUtil.close(ps,connection);
        }
        return value;
    }


}
