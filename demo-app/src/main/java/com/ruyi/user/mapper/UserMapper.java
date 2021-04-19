package com.ruyi.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.ruyi.user.entity.User;

@Repository
public interface UserMapper {
	
	List<User> selectAllUserInfo();
	
	@Select("select * from userinfo where username=#{userName}")
	User selectByPrimaryKey(String userName);
	
	@Insert("insert into userinfo(id, username, password, role) values(#{user.id}, #{user.userName}, #{user.password}, #{user.role})")
	int save(User user);
}
