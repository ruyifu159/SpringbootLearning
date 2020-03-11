package org.demo.user.service;

import java.util.List;

import org.demo.user.entity.User;
import org.demo.user.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl /* implements UserDetailsService */ {

	private static final Logger LOG = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
	
	@Autowired
	private UserMapper userMapper;
	
	public List<User> queryAllUserInfo() {
		List<User> userList = userMapper.selectAllUserInfo();
		for (User user : userList) {
			LOG.warn("==============="+user.getUserName()+": "+user.getPassword());
		}
		
		return userList;
	}
	
	public User getUser(String userName) {
		User user = userMapper.selectByPrimaryKey(userName);
		LOG.warn("用户名:"+user.getUserName()+" ，密码:  "+user.getPassword());
		return user;
	}
	
	public int save(User user) {
		return userMapper.save(user);
	}
	/*
	 * @Override public UserDetails loadUserByUsername(String username) throws
	 * UsernameNotFoundException { User user =
	 * userMapper.selectByPrimaryKey(username); return new JwtUser(user); }
	 */
}
