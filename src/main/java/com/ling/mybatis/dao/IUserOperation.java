package com.ling.mybatis.dao;

import java.util.List;

import com.ling.mybatis.model.User;

public interface IUserOperation {
	
	public User selectUserByID(int uid) ;
	
	public List<User> selectUsers(String userName);
	

}
