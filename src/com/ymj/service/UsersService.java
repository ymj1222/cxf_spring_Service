package com.ymj.service;

import java.util.List;

import com.ymj.entity.Users;


public interface UsersService {
	public List<Users> queryAll1();
	public void add();
	public void delete();
	public void update();
}
