/**
 * 
 */
package com.ruyi.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ruyi.config.JdbcDao;

import io.swagger.annotations.ApiOperation;

/**
 * @author ruyi 
 * @date 2020年7月9日 下午7:42:57
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	JdbcDao jdbcDao;
	
	@ApiOperation(value = "测试查询所有的用户信息",notes = "测试采用jdbcTemplate查询接口",httpMethod = "GET")
	//@ApiImplicitParam(dataType = "string",name = "name",value = "",required = false)
	@RequestMapping(value = "/showUser", method = RequestMethod.GET)
	public String queryAllUserInfo(HttpServletRequest req, HttpServletResponse resp) {
		
		jdbcDao.executeQuery();
		
		return "";
	}
}
