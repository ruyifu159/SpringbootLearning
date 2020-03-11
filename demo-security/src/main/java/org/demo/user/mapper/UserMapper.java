package org.demo.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.demo.user.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
	
	List<User> selectAllUserInfo();
	
	@Select("select * from \"user\" where \"userName\"=#{userName}")
	User selectByPrimaryKey(String userName);
	
	@Insert("insert into \"user\"(\"id\", \"userName\", \"password\", \"role\") values(#{user.id}, #{user.userName}, #{user.password}, #{user.role})")
	int save(User user);
}
