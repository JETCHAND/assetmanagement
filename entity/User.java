package com.assetmanagement.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user_tbl")
public class User {

 @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "user_id")
private int userId;

 
 @NotNull(message ="UserName is required")
@Column(name = "user_name",unique=true)
private String userName;

 @Column(name = "user_mobile_number",unique=true)
private long mobileNumber;

 @NotNull(message ="Address is required")
@Column(name = "user_address")
private String address;
@NotNull(message ="EmailId is required")
@Column(name = "user_email_id",unique=true)
private String emailId;

 @NotNull(message ="Password is required")
@Column(name = "user_password")
private String password;

 @NotNull(message ="UserRole is required")
@Column(name = "user_role")
private String userRole;

@JsonIgnore
@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
private Set<Order> getListOfOrders = new HashSet<>();

public int getUserId() {
return userId;
}

 public void setUserId(int userId) {
this.userId = userId;
}

 public String getUserName() {
return userName;
}

 public void setUserName(String userName) {
this.userName = userName;
}

 public long getMobileNumber() {
return mobileNumber;
}

 public void setMobileNumber(long mobileNumber) {
this.mobileNumber = mobileNumber;
}

 public String getAddress() {
return address;
}

 public void setAddress(String address) {
this.address = address;
}

 public Set<Order> getGetListOfOrders() {
return getListOfOrders;
}

 public void setGetListOfOrders(Set<Order> getListOfOrders) {
this.getListOfOrders = getListOfOrders;
}

 public String getEmailId() {
return emailId;
}

 public void setEmailId(String emailId) {
this.emailId = emailId;
}

 public String getPassword() {
return password;
}

 public void setPassword(String password) {
this.password = password;
}

public String getUserRole() {
	return userRole;
}

public void setUserRole(String userRole) {
	this.userRole = userRole;
}


}