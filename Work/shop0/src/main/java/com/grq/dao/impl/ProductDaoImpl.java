package com.grq.dao.impl;

import com.grq.bean.Product;
import com.grq.dao.ProductDao;
import com.grq.dto.PduWithC;
import com.grq.util.JdbcUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    private Connection connection;
    private ResultSet resultSet;
    private PreparedStatement ps;


    @Override
    public List<Product> getAll() {
        List<Product> list=new ArrayList<>();
        Product product=null;
        try {
            connection= JdbcUtil.getConnection();
            String sql="select * from product";
            ps=connection.prepareStatement(sql);
            resultSet=ps.executeQuery();
            while (resultSet.next()){
                product=new Product();
                product.setId(resultSet.getInt("id"));
                product.setPname(resultSet.getString("pname"));
                product.setCid(resultSet.getInt("cid"));
                product.setPvalue(resultSet.getDouble("pvalue"));
                product.setPimg(resultSet.getString("pimg"));
                product.setDescribe(resultSet.getString("describe"));
                list.add(product);
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
    public Product getById(int id) {
        Product product=null;
        try {
            connection= JdbcUtil.getConnection();
            String sql="select * from product where id =?";
            ps=connection.prepareStatement(sql);
            ps.setInt(1,id);
            resultSet=ps.executeQuery();
            while (resultSet.next()){
                product=new Product();
                product.setId(resultSet.getInt("id"));
                product.setPname(resultSet.getString("pname"));
                product.setCid(resultSet.getInt("cid"));
                product.setPvalue(resultSet.getDouble("pvalue"));
                product.setPimg(resultSet.getString("pimg"));
                product.setDescribe(resultSet.getString("describe"));
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
        return product;
    }

    @Override
    public int addProduct(Product product) {
        int value=0;
        try {
            connection= JdbcUtil.getConnection();
            String sql="INSERT into product (pname,pvalue,cid,`describe`,pimg)values(?,?,?,?,?)";
            ps=connection.prepareStatement(sql);
            ps.setString(1,product.getPname());
            ps.setDouble(2,product.getPvalue());
            ps.setInt(3,product.getCid());
            ps.setString(4,product.getDescribe());
            ps.setString(5,product.getPimg());
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
    public int deleteById(int id) {
        int value=0;
        try {
            connection= JdbcUtil.getConnection();
            String sql="delete from product where id=?";
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
    public int update(Product product) {
        int value=0;
        try {
            connection= JdbcUtil.getConnection();
            String sql="UPDATE product set pname=?,pvalue=?,cid=?,`describe`=?,pimg=? where id =?";
            ps=connection.prepareStatement(sql);
            ps.setString(1,product.getPname());
            ps.setDouble(2,product.getPvalue());
            ps.setInt(3,product.getCid());
            ps.setString(4,product.getDescribe());
            ps.setString(5,product.getPimg());
            ps.setInt(6,product.getId());
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
    public List<PduWithC> getPduWithCname() {
        List<PduWithC> list=new ArrayList<>();
        PduWithC product=null;
        try {
            connection= JdbcUtil.getConnection();
            String sql="select p.id ,p.pname,p.pvalue,p.pimg,c.cname, p.`describe`FROM product AS p LEFT JOIN class AS c ON p.cid=c.id";
            ps=connection.prepareStatement(sql);
            resultSet=ps.executeQuery();
            while (resultSet.next()){
                product=new PduWithC();
                product.setId(resultSet.getInt("id"));
                product.setPname(resultSet.getString("pname"));
                product.setCname(resultSet.getString("cname"));
                product.setPvalue(resultSet.getDouble("pvalue"));
                product.setPimg(resultSet.getString("pimg"));
                product.setDescribe(resultSet.getString("describe"));
                list.add(product);
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
