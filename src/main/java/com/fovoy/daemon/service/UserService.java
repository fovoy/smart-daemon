package com.fovoy.daemon.service;

import com.fovoy.daemon.model.User;

public interface UserService {
    User getUserById(int userId);

    User getUserByUserName(String userName);
}
