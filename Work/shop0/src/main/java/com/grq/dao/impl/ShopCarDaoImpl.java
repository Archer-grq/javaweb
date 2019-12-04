package com.grq.dao.impl;

import com.grq.bean.ShopCar;
import com.grq.bean.User;
import com.grq.dao.ShopCarDao;
import com.grq.dto.SCWithP;
import com.grq.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShopCarDaoImpl implements ShopCarDao {
    private Connection connection;
    private ResultSet resultSet;
    private PreparedStatement ps;

    @Override
    public int add(ShopCar shopCar) {
        int value=0;
        try {
            connection= JdbcUtil.getConnection();
            String sql="insert into shopcar (pid,uid,pnum)values (?,?,?)";
            ps=connection.prepareStatement(sql);
            ps.setInt(1,shopCar.getPid());
            ps.setInt(2,shopCar.getUid());
            ps.setInt(3,shopCar.getNum());
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
            String sql="delete from shopcar where id=?";
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
    public int deleteAll(int uid){
        int value=0;
        try {
            connection= JdbcUtil.getConnection();
            String sql="delete from shopcar where uid=?";
            ps=connection.prepareStatement(sql);
            ps.setInt(1,uid);
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
    public int update(ShopCar shopCar) {
        int value=0;
        try {
            connection= JdbcUtil.getConnection();
            String sql="update shopcar set pnum=? where uid=? and pid =? ";
            ps=connection.prepareStatement(sql);
            ps.setInt(1,shopCar.getNum());
            ps.setInt(2,shopCar.getUid());
            ps.setInt(3,shopCar.getPid());
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
    public List<ShopCar> getByUid(int uid) {
        List<ShopCar> list=new ArrayList<>();
        ShopCar shopCar=null;
        try {
            connection= JdbcUtil.getConnection();
            String sql="select * from shopcar where uid=?";
            ps=connection.prepareStatement(sql);
            ps.setInt(1,uid);
            resultSet=ps.executeQuery();
            while (resultSet.next()){
                shopCar =new ShopCar();
                shopCar.setId(resultSet.getInt("id"));
                shopCar.setPid(resultSet.getInt("pid"));
                shopCar.setUid(resultSet.getInt("uid"));
                shopCar.setNum(resultSet.getInt("pnum"));
                list.add(shopCar);
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
    public List<SCWithP> getSCPByUid(int uid) {
        List<SCWithP> list=new ArrayList<>();
        SCWithP sc=null;
        try {
            connection= JdbcUtil.getConnection();
            String sql="SELECT s.id AS id,s.pnum AS num,s.uid AS uid, s.pid AS pid,p.pname As pname ,p.pvalue AS pvalue FROM `shopcar` AS s LEFT JOIN product AS p ON s.pid=p.id WHERE s.uid=?";
            ps=connection.prepareStatement(sql);
            ps.setInt(1,uid);
            resultSet=ps.executeQuery();
            while (resultSet.next()){
                sc=new SCWithP();
                sc.setId(resultSet.getInt("id"));
                sc.setUid(resultSet.getInt("uid"));
                sc.setPid(resultSet.getInt("pid"));
                sc.setNum(resultSet.getInt("num"));
                sc.setPname(resultSet.getString("pname"));
                sc.setPvalue(resultSet.getDouble("pvalue"));
                list.add(sc);
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
    public int checkIsHave(int uid, int pid) {
        int value=0;
        try {
            connection= JdbcUtil.getConnection();
            String sql="select count(*) AS num from shopcar GROUP BY uid,pid having uid=? and pid =?";
            ps=connection.prepareStatement(sql);
            ps.setInt(1,uid);
            ps.setInt(2,pid);
            resultSet=ps.executeQuery();
            while (resultSet.next()){
                value=resultSet.getInt("num");
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
        return value;
    }

    @Override
    public ShopCar getByPU(int uid, int pid) {
        ShopCar shopCar=null;
        try {
            connection= JdbcUtil.getConnection();
            String sql="select * from shopcar where uid=? and pid =?";
            ps=connection.prepareStatement(sql);
            ps.setInt(1,uid);
            ps.setInt(2,pid);
            resultSet=ps.executeQuery();
            while (resultSet.next()){
                shopCar =new ShopCar();
                shopCar.setId(resultSet.getInt("id"));
                shopCar.setPid(resultSet.getInt("pid"));
                shopCar.setUid(resultSet.getInt("uid"));
                shopCar.setNum(resultSet.getInt("pnum"));
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
        return shopCar;
    }

    @Override
    public int deleteByPid(int pid) {
        int value=0;
        try {
            connection= JdbcUtil.getConnection();
            String sql="delete from shopcar where pid=?";
            ps=connection.prepareStatement(sql);
            ps.setInt(1,pid);
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
}
