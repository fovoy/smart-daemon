package com.fovoy.daemon.service;

import com.fovoy.daemon.model.UserInfo;

public interface UserService {
    UserInfo getUserById(int userId);

    UserInfo getUserByUserName(String userName);

    UserInfo AuthUser(String user,String password);
}
