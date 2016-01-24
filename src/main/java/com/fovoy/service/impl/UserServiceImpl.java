package com.fovoy.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fovoy.dao.IUserDao;
import com.fovoy.pojo.User;
import com.fovoy.service.IUserService;

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
