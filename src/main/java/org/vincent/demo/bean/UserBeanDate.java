package org.vincent.demo.bean;

import java.util.Date;

import org.vincent.demo.util.JsonDateFormatFull;

import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class UserBeanDate {
	private int userId;  
    private String userName;  
    private String password;  
    private String email;
    
	@JsonSerialize(using= JsonDateFormatFull.class)
    private  Date createDate; 
    
    public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
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
    public String getPassword() {  
        return password;  
    }  
    public void setPassword(String password) {  
        this.password = password;  
    }  
    public String getEmail() {  
        return email;  
    }  
    public void setEmail(String email) {  
        this.email = email;  
    }  
    
    @Override
	public String toString() {
		return "UserBeanDate [userId=" + userId + ", userName=" + userName + ", password=" + password + ", email="
				+ email + ", createDate=" + createDate + "]";
	}
	public UserBeanDate(int userId, String userName, String password, String email) {  
        super();  
        this.userId = userId;  
        this.userName = userName;  
        this.password = password;  
        this.email = email;  
    }  
    public UserBeanDate() {  
        super();  
    } 
}
