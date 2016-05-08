package com.ling.mybatis.model;

import java.util.Date;

public class User {
	
	private String uid;
	private String userName;
	private String pwd;
	private Date birthday;
	private String email;
	
	public User() {
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", userName=" + userName + ", pwd=" + pwd + ", birthday=" + birthday + ", email="
				+ email + "]";
	}
	
	
	
}
