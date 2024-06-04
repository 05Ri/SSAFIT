package com.ssafit.model.dao;

import com.ssafit.model.dto.User;

public interface UserDao {
    
    User selectOne(User user);
    
    User selectById(String id);
    
    int insert(User user);
}