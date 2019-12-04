package com.grq.bean;

import java.io.Serializable;

public class ProductClass implements Serializable {
    private int id;
    private String cname;

    @Override
    public String toString() {
        return "ProductClass{" +
                "id=" + id +
                ", cname='" + cname + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public ProductClass() {
    }

    public ProductClass(int id, String cname) {
        this.id = id;
        this.cname = cname;
    }
}
