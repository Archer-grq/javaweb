package com.grq.bean;

import java.io.Serializable;

public class Product implements Serializable {
    private int id;
    private String pname;
    private double pvalue;
    private String pimg;
    private int cid;
    private String describe;

    public Product(int id, String pname, double pvalue, String pimg, int cid, String describe) {
        this.id = id;
        this.pname = pname;
        this.pvalue = pvalue;
        this.pimg = pimg;
        this.cid = cid;
        this.describe = describe;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", pname='" + pname + '\'' +
                ", pvalue=" + pvalue +
                ", pimg='" + pimg + '\'' +
                ", cid=" + cid +
                ", describe='" + describe + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getPimg() {
        return pimg;
    }

    public void setPimg(String pimg) {
        this.pimg = pimg;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Product() {
    }

    public Product(String pname, double pvalue, String pimg, int cid, String describe) {
        this.pname = pname;
        this.pvalue = pvalue;
        this.pimg = pimg;
        this.cid = cid;
        this.describe = describe;
    }
}
