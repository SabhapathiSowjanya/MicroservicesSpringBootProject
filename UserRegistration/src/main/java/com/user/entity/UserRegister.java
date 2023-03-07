package com.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="user_registrations")
public class UserRegister {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="user_id")
	private Integer userId;
	@Column(name="user_name")
	private String userName;
	@Column(name="password")
	private String userPassword;
	@Column(name="mobileNo")
	private String mobileNo;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	@Override
	public String toString() {
		return "UserRegister [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword
				+ ", mobileNo=" + mobileNo + "]";
	}
	public UserRegister(Integer userId, String userName, String userPassword, String mobileNo) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.mobileNo = mobileNo;
	}
	public UserRegister() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
