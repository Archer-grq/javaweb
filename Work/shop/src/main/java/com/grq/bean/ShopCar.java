package com.grq.bean;

import java.io.Serializable;

public class ShopCar implements Serializable {
    private int id;
    private int uid;
    private int pid;
    private int pnum;


    public ShopCar(int id, int uid, int pid, int pnum) {
        this.id = id;
        this.uid = uid;
        this.pid = pid;
        this.pnum = pnum;
    }

    public ShopCar() {
    }

    public ShopCar(int uid, int pid, int pnum) {
        this.uid = uid;
        this.pid = pid;
        this.pnum = pnum;
    }

    @Override
    public String toString() {
        return "ShopCar{" +
                "id=" + id +
                ", uid=" + uid +
                ", pid=" + pid +
                ", pnum=" + pnum +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getPnum() {
        return pnum;
    }

    public void setPnum(int pnum) {
        this.pnum = pnum;
    }
}
