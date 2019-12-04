package com.grq.bean.dto;

import java.io.Serializable;

public class SCWithP implements Serializable {
    //购物车id
    private int id;
    private int pid;
    private int num;
    private String pname;
    private double pvalue;
    private int uid;

    public SCWithP() {
    }

    @Override
    public String toString() {
        return "SCWithP{" +
                "id=" + id +
                ", pid=" + pid +
                ", num=" + num +
                ", pname='" + pname + '\'' +
                ", pvalue=" + pvalue +
                ", uid=" + uid +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public double getPvalue() {
        return pvalue;
    }

    public void setPvalue(double pvalue) {
        this.pvalue = pvalue;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public SCWithP(int id, int pid, int num, String pname, double pvalue, int uid) {
        this.id = id;
        this.pid = pid;
        this.num = num;
        this.pname = pname;
        this.pvalue = pvalue;
        this.uid = uid;
    }
}
