package com.whs.service;

import com.whs.bean.User;

public interface UserService {

    User check(String username, String password);

    User findWhs(Long id);

    User findById(Long id);
}
