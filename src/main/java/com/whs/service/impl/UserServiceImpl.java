package com.whs.service.impl;

import com.whs.bean.User;
import com.whs.dao.UserDao;
import com.whs.service.UserService;
import com.whs.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;


    @Override
    public User check(String username, String password) {

        User user=userDao.findByUsernameAndPassword(username, MD5Util.code(password));
        return user;
    }

    @Override
    public User findWhs(Long id) {
        return userDao.getById(1L);
    }

    @Override
    public User findById(Long id) {
        return userDao.getById(id);
    }
}
