package com.fovoy.daemon.service.impl;

import javax.annotation.Resource;

import com.fovoy.daemon.model.User;
import com.fovoy.daemon.service.IUserService;
import org.springframework.stereotype.Service;

import com.fovoy.daemon.dao.IUserDao;

@Service("userService")
public class UserServiceImpl implements IUserService {
	@Resource
	private IUserDao userDao;
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
