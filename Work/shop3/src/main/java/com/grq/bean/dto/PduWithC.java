package com.grq.bean.dto;

import java.io.Serializable;

public class PduWithC implements Serializable {

	private int id;
    private String pname;
    private double pvalue;
    private String pimg;
    private String cname;
    private String describe;

    public PduWithC(String pname, double pvalue, String pimg, String cname, String describe) {
        this.pname = pname;
        this.pvalue = pvalue;
        this.pimg = pimg;
        this.cname = cname;
        this.describe = describe;
    }

    @Override
    public String toString() {
        return "PduWithC{" +
                "id=" + id +
                ", pname='" + pname + '\'' +
                ", pvalue=" + pvalue +
                ", pimg='" + pimg + '\'' +
                ", cname='" + cname + '\'' +
                ", describe='" + describe + '\'' +
                '}';
    }

    public PduWithC() {
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

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public PduWithC(int id, String pname, double pvalue, String pimg, String cname, String describe) {
        this.id = id;
        this.pname = pname;
        this.pvalue = pvalue;
        this.pimg = pimg;
        this.cname = cname;
        this.describe = describe;
    }
}
