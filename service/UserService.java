package com.assetmanagement.service;

import java.util.List;

import com.assetmanagement.entity.User;

public interface UserService {

	public User doLogin(String userName, String password,String userRole);

	public User saveUser(User user);

	public List<User> getAllUser();
	
	public List<User> getAllUserByRole(String userRole);

	public User getUserById(int userId);

	public User updateUser(User user);

	public void deleteUserById(int userId);
	
}
