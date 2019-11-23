package com.grq.bean;

import java.io.Serializable;

public class ShopCar implements Serializable {
    private int id;
    private int uid;
    private int pid;
    private int num;

    @Override
    public String toString() {
        return "ShopCar{" +
                "id=" + id +
                ", uid=" + uid +
                ", pid=" + pid +
                ", num=" + num +
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

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public ShopCar() {
    }

    public ShopCar(int uid, int pid, int num) {
        this.uid = uid;
        this.pid = pid;
        this.num = num;
    }

    public ShopCar(int id, int uid, int pid, int num) {
        this.id = id;
        this.uid = uid;
        this.pid = pid;
        this.num = num;
    }
}
