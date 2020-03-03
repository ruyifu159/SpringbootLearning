package com.ruyi.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.ruyi.user.entity.User;

@Repository
public interface UserMapper {
	
	List<User> selectAllUserInfo();
	
	@Select("select * from \"user\" where \"userName\"=#{userName}")
	User selectByPrimaryKey(String userName);
}
