package com.grq.bean;

import java.io.Serializable;
import java.sql.Date;

/**
 * 订单信息表
 */
public class Order implements Serializable {

    private int id;
    private int cid;
    private int pid;

    /**
     * 商品数量
     */
    private int pNum;

    /**
     * 订单总价格
     */
    private double money;

    /**
     * 0表示未发货
     * 1表示已发货
     */
    private int isSend;

    /**
     * 订单创建时间
     */
    private Date createdTime;

    /**
     * 收货地址
     */
    private String destination;

    @Override
    public String toString() {
        return "order{" +
                "id=" + id +
                ", cid=" + cid +
                ", pid=" + pid +
                ", pNum=" + pNum +
                ", money=" + money +
                ", isSend=" + isSend +
                ", createdTime=" + createdTime +
                ", destination='" + destination + '\'' +
                '}';
    }

    public Order(int id, int cid, int pid, int pNum, double money, int isSend) {
        this.id = id;
        this.cid = cid;
        this.pid = pid;
        this.pNum = pNum;
        this.money = money;
        this.isSend = isSend;
    }

    public Order() {
    }

    public Order(int id, int cid, int pid, int pNum, double money, int isSend, Date createdTime, String destination) {
        this.id = id;
        this.cid = cid;
        this.pid = pid;
        this.pNum = pNum;
        this.money = money;
        this.isSend = isSend;
        this.createdTime = createdTime;
        this.destination = destination;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getpNum() {
        return pNum;
    }

    public void setpNum(int pNum) {
        this.pNum = pNum;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getIsSend() {
        return isSend;
    }

    public void setIsSend(int isSend) {
        this.isSend = isSend;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
