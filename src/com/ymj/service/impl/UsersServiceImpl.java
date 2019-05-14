package com.ymj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ymj.dao.UsersDao;
import com.ymj.entity.Users;
import com.ymj.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService {
	@Autowired
	private UsersDao<Users> usersDao;
	
	@Override
	public List<Users> queryAll1() {
		
		return usersDao.queryAll();
	}
	@Override
	public void add() {
		usersDao.add();
	}
	@Override
	public void delete() {
		usersDao.delete();
	}
	@Override
	public void update() {
		usersDao.update();
	}
}
