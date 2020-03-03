package com.ruyi.user.controller;

//import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ruyi.user.entity.User;
import com.ruyi.user.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	public UserService userService;
	
	
	@RequestMapping(value = "/showUser", method = RequestMethod.GET)
	public ModelAndView startPage(HttpServletRequest req, HttpServletResponse resp) {
		ModelAndView mv = new ModelAndView();
		
		//List<User> userInfoList = userService.queryAllUserInfo();
		/*
		for (User user : userInfoList) {
			mv.addObject("user", user);
		}
		*/
		//User user = new User();
		//user.setUserName("ruyi");
		//user.setPassword("123456");		
		User user = userService.getUser("李四");
		mv.addObject("user", user);
		
		mv.setViewName("showUser.html");
		
		return mv;
	}
}
