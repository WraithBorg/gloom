package com.cthulhu.mapper;

import com.cthulhu.entity.UserInfoBean;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface UserMapper {

	@Results(value = {
			@Result(property = "id", column = "id"),
			@Result(property = "name", column = "name"),
			@Result(property = "password", column = "password")
	})
	@Select("select id,name,password from userinfo")
	List<UserInfoBean> getUsers();
}
