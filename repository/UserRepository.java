package com.assetmanagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.assetmanagement.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{


	public List<User> findByUserRole(String userRole);
	Optional<User> findByUserName(String userName);
	Optional<User> findByEmailId(String emailId);
	Optional<User> findByMobileNumber(long mobileNumber);
	
	@Query("select u from User u where u.userName = :uname and u.password = :upwd and u.userRole = :urole")
	User login( @Param ("uname")String username, @Param ("upwd")String password, @Param ("urole")String userrole);

}
