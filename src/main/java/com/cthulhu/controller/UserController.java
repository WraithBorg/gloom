package com.cthulhu.controller;

import com.cthulhu.datasource.DBIdentifier;
import com.cthulhu.entity.UserInfoBean;
import com.cthulhu.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {
	@Autowired
	private UserMapper userMapper;

	@RequestMapping(value = "/users",method = RequestMethod.GET)
	public List<UserInfoBean> queryAllUser(@RequestParam(value = "projectCode")String projectCode){
		// http://127.0.0.1:8080/user/users?projectCode=project_001
		DBIdentifier.setProjectCode(projectCode);
		return userMapper.getUsers();
	}
}
