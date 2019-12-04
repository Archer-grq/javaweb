package com.grq.dao;

import com.grq.bean.Order;

public interface OrderDao {

    int insert(Order order);
    int updateIsSend(int id);
    int delete(int id);

}
