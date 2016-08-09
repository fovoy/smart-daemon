package com.fovoy.daemon.service;

import com.fovoy.daemon.model.User;

public interface IUserService {
	public User getUserById(int userId);
	public User getUserByUserName(String userName);
}
