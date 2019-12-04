package com.grq.bean.dto;

import java.io.Serializable;
import java.sql.Date;

public class OrderDto implements Serializable {

    private int id;
    private int cid;
    private int pid;
    private int pName;
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

}
