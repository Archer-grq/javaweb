package com.grq.dao.impl;

import com.grq.bean.ShopCar;
import com.grq.dao.ShopCarDao;
import com.grq.bean.dto.SCWithP;
import com.grq.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShopCarDaoImpl implements ShopCarDao {

    @Override
    public int add(ShopCar shopCar) {
        return JdbcUtil.insertWithOutKey("id", "shopcar", shopCar, ShopCar.class);
    }

    @Override
    public int deleteById(int id) {
        return JdbcUtil.delete("delete from shopcar where id=?", new Object[]{id});
    }

    @Override
    public int deleteAll(int uid){
        return JdbcUtil.delete("delete from shopcar where uid=?", new Object[]{uid});
    }

    @Override
    public int update(ShopCar shopCar) {
        return JdbcUtil.update("update shopcar set pnum=? where uid=? and pid =?"
                , new Object[]{shopCar.getPnum(), shopCar.getUid(), shopCar.getPid()});
    }

    @Override
    public List<ShopCar> getByUid(int uid) {
       return JdbcUtil.select("select * from shopcar where uid=?", new Object[]{uid}, ShopCar.class);
    }

    @Override
    public List<SCWithP> getSCPByUid(int uid) {
        return JdbcUtil.select("SELECT s.id AS id,s.pnum AS num,s.uid AS uid, s.pid AS pid,p.pname As pname ,p.pvalue AS pvalue FROM `shopcar` AS s LEFT JOIN product AS p ON s.pid=p.id WHERE s.uid=?"
                , new Object[]{uid}
                , SCWithP.class);
    }

    @Override
    public int checkIsHave(int uid, int pid) {

        List<ShopCar> select = JdbcUtil.select("select * from shopcar where uid =? and pid =?", new Object[]{uid, pid}, ShopCar.class);
        return select.size();
    }

    @Override
    public ShopCar getByPU(int uid, int pid) {
        List<ShopCar> select = JdbcUtil.select("select * from shopcar where uid=? and pid =?"
                , new Object[]{uid, pid},ShopCar.class);
        if(select.size()==0){
            return null;
        }else {
            return select.get(0);
        }
    }

    @Override
    public int deleteByPid(int pid) {
        return JdbcUtil.delete("delete from shopcar where pid=?", new Object[]{pid});
    }
}
