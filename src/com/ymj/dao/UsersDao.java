package com.ymj.dao;

import java.util.List;

public interface UsersDao<T> {

	// ��ѯ
	public List<T> queryAll();
	
	public void add();
	
	public void delete();
	
	public void update();

}