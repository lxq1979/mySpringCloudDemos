package com.xiaoqiao.springcloud.facade.entity;

import java.io.Serializable;
import java.util.Date;



public class User implements Serializable{
    private static final long serialVersionUID = 8608241525895477781L;

    private String userId;
    private String userName;
    private String password;
    private Date createDate;
    
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
}
