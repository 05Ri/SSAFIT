package com.ssafit.model.service;

import org.springframework.stereotype.Service;

import com.ssafit.model.dao.UserDao;
import com.ssafit.model.dto.User;

@Service
public class UserServiceImpl implements UserService {
    UserDao dao;

    public UserServiceImpl(UserDao dao) {
        this.dao = dao;
    }

    @Override
    public User getUser(User user) {
        return dao.selectOne(user);
    }

    @Override
    public int signUp(User user) {
        // 중복 체크
        if (dao.selectById(user.getUserId()) == null) {
            return dao.insert(user);            
        }
        return 0;
    }

}