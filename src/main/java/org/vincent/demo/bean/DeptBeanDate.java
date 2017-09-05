package org.vincent.demo.bean;

import java.util.Date;
import java.util.List;

import org.vincent.demo.util.JsonDateFormatFull;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class DeptBeanDate {
	private int deptId;  
    private String deptName;  
    private List<UserBeanDate> userBeanList;  
    @JsonSerialize(using=JsonDateFormatFull.class)
    private  Date createDate; 
      
    public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public int getDeptId() {  
        return deptId;  
    }  
    public void setDeptId(int deptId) {  
        this.deptId = deptId;  
    }  
    public String getDeptName() {  
        return deptName;  
    }  
    public void setDeptName(String deptName) {  
        this.deptName = deptName;  
    }  
    public List<UserBeanDate> getUserBeanList() {  
        return userBeanList;  
    }  
    public void setUserBeanList(List<UserBeanDate> userBeanList) {  
        this.userBeanList = userBeanList;  
    }  
      
      
      
    @Override  
    public String toString() {  
        String userBeanListString = "";  
        for (UserBeanDate UserBeanDate1 : userBeanList) {  
            userBeanListString += UserBeanDate1.toString() + "\n";  
        }  
          
        return "DeptBean [deptId=" + deptId + ", deptName=" + deptName +", createDate= "+createDate 
                + ", \nuserBeanListString=" + userBeanListString + "]";  
    }  
    public DeptBeanDate(int deptId, String deptName, List<UserBeanDate> userBeanList) {  
        super();  
        this.deptId = deptId;  
        this.deptName = deptName;  
        this.userBeanList = userBeanList;  
    }  
    public DeptBeanDate() {  
        super();  
    }
	
}
