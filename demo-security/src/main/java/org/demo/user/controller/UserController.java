package org.demo.user.controller;

import org.demo.user.entity.User;
import org.demo.user.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController { 
	
	@Autowired
	public UserDetailsServiceImpl userService;  
	
	@RequestMapping("/showUser")
	public String startPage(Model model) {
		User user = userService.getUser("李四");  
		model.addAttribute("user", user);
		return "showUser.html";
	}
}
