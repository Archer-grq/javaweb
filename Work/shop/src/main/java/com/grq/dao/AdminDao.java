package com.grq.dao;

import com.grq.bean.Admin;

public interface AdminDao {
    Admin getAdminByName(String name);
}
