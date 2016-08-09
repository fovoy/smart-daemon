package com.fovoy.daemon.service.impl;

import javax.annotation.Resource;
import com.fovoy.daemon.model.User;
import com.fovoy.daemon.service.UserService;
import org.springframework.stereotype.Service;

import com.fovoy.daemon.dao.UserDao;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao userDao;
	@Override
	public User getUserById(int userId) {
		// TODO Auto-generated method stub
		return userDao.selectByPrimaryKey(userId);
	}
	@Override
	public User getUserByUserName(String userName){
		return userDao.selectByUserName(userName);

	}

}
