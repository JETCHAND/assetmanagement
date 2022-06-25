package com.assetmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assetmanagement.entity.User;
import com.assetmanagement.exception.AuthenticationFailedException;
import com.assetmanagement.exception.EmaiIdAlreadyExistingException;
import com.assetmanagement.exception.MobileNumberAlreadyExistingException;
import com.assetmanagement.exception.UserNameAlreadyExistingException;
import com.assetmanagement.exception.UserNotFoundException;
import com.assetmanagement.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService {


	@Autowired
	private UserRepository userRepository;

	@Override
	public User doLogin(String userName, String password, String userRole) {

		User  user = userRepository.login(userName, password, userRole);
		if(user==null) {
			throw new AuthenticationFailedException("Username or password invalid");
		}
		return user;
	}

	@Override
	public User saveUser(User user) {
		
		Optional<User> optionalUserName = userRepository.findByUserName(user.getUserName());
		if(optionalUserName.isPresent()) {
			throw new UserNameAlreadyExistingException("Username already existing");

		}
		
		Optional<User> optionalUserbyEmailId = userRepository.findByEmailId(user.getEmailId());
		 if(optionalUserbyEmailId.isPresent()) {
			throw new EmaiIdAlreadyExistingException("EmailId already existing");
		}
		
		Optional<User> optionalUserbyMobileNumber =userRepository.findByMobileNumber(user.getMobileNumber());
		if(optionalUserbyMobileNumber.isPresent()) {
			throw new MobileNumberAlreadyExistingException("MobileNumber already existing");
		}
		
		
		User newUser = userRepository.save(user);
		return newUser;
	}

	@Override
	public List<User> getAllUser() {

		List<User> allUser = userRepository.findAll();
		return allUser;
	}

	@Override
	public User getUserById(int userId) throws UserNotFoundException {

		Optional<User> optionalUser = userRepository.findById(userId);
		if (optionalUser.isEmpty()) {
			throw new UserNotFoundException("User not found with this Id :" + userId);
		}
		User userById = optionalUser.get();
		return userById;
	}

	@Override
	public User updateUser(User user) {

		Optional<User> optionalUser = userRepository.findById(user.getUserId());
		if (optionalUser.isEmpty()) {
			throw new UserNotFoundException("User not found with this Id :" + user.getUserId());
		}
		User updatedUser = userRepository.save(user);
		return updatedUser;
	}

	@Override
	public void deleteUserById(int userId) {

		Optional<User> optionalUser = userRepository.findById(userId);
		if (optionalUser.isEmpty()) {
			throw new UserNotFoundException("User not found with this Id :" + userId);
		}

		userRepository.deleteById(userId);
	}

	@Override
	public List<User> getAllUserByRole(String userRole) {
		
        List<User> userByRole = userRepository.findByUserRole(userRole);
        if(userByRole.size() == 0) {
        	throw new UserNotFoundException("User not found with this name : " + userRole);
        }
		return userByRole;
	}

	
}
