package com.fovoy.service;

import com.fovoy.pojo.User;

public interface IUserService {
	public User getUserById(int userId);
	public User getUserByUserName(String userName);
}
