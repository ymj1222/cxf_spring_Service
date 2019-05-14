package com.ymj.webservice.Impl;

import java.util.List;

import javax.annotation.Resource;
import javax.jws.WebService;

import com.ymj.entity.Users;
import com.ymj.service.UsersService;
import com.ymj.webservice.UsersWebService;


@WebService
public class UsersWebServiceImpl implements UsersWebService {
	
	@Resource
	private UsersService usersService;

	
	@Override
	public List<Users> query() {
		return usersService.queryAll1();
	}
	
	@Override
	public void add() {
		usersService.add();
	}
	@Override
	public void delete() {
		usersService.delete();
	}
	@Override
	public void update() {
		usersService.update();
	}
}
