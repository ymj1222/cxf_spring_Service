package com.ymj.webservice;

import java.util.List;

import javax.jws.WebService;

import com.ymj.entity.Users;

@WebService
public interface UsersWebService {
	public List<Users> query();
	public void add();
	public void delete();
	public void update();
}
