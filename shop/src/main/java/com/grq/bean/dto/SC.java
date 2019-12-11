package com.grq.bean.dto;

import java.io.Serializable;

public class SC implements Serializable {

    private int id;
    private int pid;
    private int num;
    private String pimg;
    private String pname;
    private double pvalue;
    private int uid;

    public SC() {
    }

    @Override
    public String toString() {
        return "SC{" +
                "id=" + id +
                ", pid=" + pid +
                ", num=" + num +
                ", pimg='" + pimg + '\'' +
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

    public String getPimg() {
        return pimg;
    }

    public void setPimg(String pimg) {
        this.pimg = pimg;
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
}
