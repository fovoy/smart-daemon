package com.fovoy.daemon.service.impl;

import javax.annotation.Resource;

import com.fovoy.daemon.model.UserInfo;
import com.fovoy.daemon.service.UserService;
import org.springframework.stereotype.Service;

import com.fovoy.daemon.dao.UserDao;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public UserInfo getUserById(int userId) {
        // TODO Auto-generated method stub
        return userDao.selectByPrimaryKey(userId);
    }

    @Override
    public UserInfo getUserByUserName(String userName) {
        return userDao.selectByUserName(userName);

    }

    @Override
    public UserInfo AuthUser(String user, String password) {
        UserInfo userInfo = userDao.authUser(user, password);
        return userInfo;
    }
}
