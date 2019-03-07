package com.practice.controllers;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.practice.dao.PasswordDAO;
import com.practice.dao.UsernameDAO;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/login")
public class UsernameController {
	
	@Autowired
	UsernameDAO userDao;
	
	@RequestMapping("/{username}/{password}")
	public boolean login(@PathVariable("username")String username, @PathVariable("password")String password)
	{
//		System.out.println("IN UN: " + username);
//		System.out.println("IN PW: " + password);
		
		String id = userDao.getUserId(username);
//		System.out.println("DB ID: " + id);
		if(!id.equals("invalid"))
		{
			String url = "http://localhost:8090/hidden/" + password + "/" + id;
			
			RestTemplate restTemplate = new RestTemplate();
			String result = restTemplate.getForObject(url, String.class);
			
			if(result.equals("true"))
				return true;
			else
				return false;
			
		}
		else
			return false;
	}
}
