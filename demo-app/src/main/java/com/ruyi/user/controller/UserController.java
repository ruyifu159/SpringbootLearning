package com.ruyi.user.controller;

import java.util.Map;

//import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ruyi.user.entity.User;
import com.ruyi.user.service.UserDetailsServiceImpl;

@RestController
@RequestMapping(value = "/auth")
public class UserController {
	
	@Autowired
	public UserDetailsServiceImpl userService;
	
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
	
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/register")
    public String registerUser(@RequestBody Map<String,String> registerUser){
        User user = new User();
        user.setUserName(registerUser.get("username"));
        user.setPassword(bCryptPasswordEncoder.encode(registerUser.get("password")));
        user.setRole("ROLE_USER");
        int flag = userService.save(user);
        return String.valueOf(flag);
    }
}
