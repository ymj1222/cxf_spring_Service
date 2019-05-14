package com.ymj.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ymj.dao.UsersDao;
import com.ymj.entity.Users;

@Repository
public class UsersDaoImpl implements UsersDao<Users> {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	
	@Override
	public List<Users> queryAll() {
		String sql = "select * from users";
		RowMapper<Users> rowMapper = new BeanPropertyRowMapper<>(Users.class);
		List<Users> stuList = jdbcTemplate.query(sql, rowMapper);
		for (Users student : stuList) {
			System.out.println(student.toString());
		}
		return stuList;
	}
	@Override
	public void add() {
		String sql = "insert into users(id,name,age,sex,addr)values(?,?,?,?,?);";
		jdbcTemplate.update(sql,11,"超儿子",100,"男","深圳");
	}

	@Override
	public void delete() {
			String sql = "delete from users where id =?";
			jdbcTemplate.update(sql,11);
	}
	@Override
	public void update() {
		String sql = "update users set addr=? where id =?";
		jdbcTemplate.update(sql,"已修改",11);
	}
}
