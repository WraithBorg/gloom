package com.cthulhu.controller;

import com.cthulhu.datasource.DBIdentifier;
import com.cthulhu.entity.UserInfoBean;
import com.cthulhu.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserController {
	@Resource
	private UserMapper userMapper;

	@RequestMapping(value = "/{data_source_url}/user/users",method = RequestMethod.GET)
	public List<UserInfoBean> queryAllUser(@PathVariable(value = "data_source_url")String projectCode){
		DBIdentifier.setProjectCode(projectCode);
		return userMapper.getUsers();
	}
}
