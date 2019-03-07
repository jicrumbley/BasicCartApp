package com.practice.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.practice.entity.User;

@Component
public class UsernameDAOImpl implements UsernameDAO {

	@Autowired
	JdbcTemplate jdbc;
	
	@Override
	public String getUserId(String name) {
		// TODO Auto-generated method stub
		return jdbc.query("select * from practice_user where user_name like '" + name + "'", (rs) -> {
			if(rs.next())
			{
				User u = new User();
				u.setUsername(rs.getString(1));
				u.setId(rs.getInt(2));
				return "" + u.getId();
			}
			else
				return "invalid";
		});
	}

}
