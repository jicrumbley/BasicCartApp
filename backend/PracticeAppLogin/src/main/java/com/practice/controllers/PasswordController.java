package com.practice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.dao.PasswordDAO;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/hidden")
public class PasswordController {

	@Autowired
	PasswordDAO passwordDao;
	
	@RequestMapping("/{password}/{userId}")
	public String checkPasswordCorrect(@PathVariable("password") String password, @PathVariable("userId") int userId)
	{
		String pword = passwordDao.getUserPassword(userId);
		if(pword.equals(password))
			return "true";
		else
			return "false";
	}
}
