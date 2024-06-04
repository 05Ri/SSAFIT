package com.ssafit.model.service;

import com.ssafit.model.dto.User;

public interface UserService {
    
    User getUser(User user);
    
    int signUp(User user);
}