package com.practice.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.practice.entity.Password;

@Component
public class PasswordDAOImpl implements PasswordDAO {

	@Autowired
	JdbcTemplate jdbc;
	
	@Override
	public String getUserPassword(int id) {
		// TODO Auto-generated method stub
		return jdbc.query("select * from practice_password where user_id = " + id, (rs) -> {
			if(rs.next())
			{
				Password p = new Password();
				p.setId(rs.getInt(1));
				p.setPassword(rs.getString(2));
				return p.getPassword();
			}
			else
				return "invalid";
		});
	}

}
