package org.vincent.demo;

 
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


import org.vincent.demo.bean.DeptBeanDate;
import org.vincent.demo.bean.UserBeanDate;
import org.vincent.demo.util.JacksonUtil;

import com.fasterxml.jackson.core.type.TypeReference;

public class JacksonDemoDate {
	 public static void main(String[] args) {
		 UserBeanDate userBean1 = new UserBeanDate(1, "liubei", "123", "liubei@163.com");  
	        userBean1.setCreateDate(new Date(Calendar.getInstance().getTimeInMillis()));  
	        UserBeanDate userBean2 = new UserBeanDate(2, "guanyu", "123", "guanyu@163.com");  
	        userBean2.setCreateDate(new Date(Calendar.getInstance().getTimeInMillis()));  
	        UserBeanDate userBean3 = new UserBeanDate(3, "zhangfei", "123", "zhangfei@163.com");  
	        userBean3.setCreateDate(new Date(Calendar.getInstance().getTimeInMillis()));  
	          
	          
	        List<UserBeanDate> userBeans = new ArrayList<>();  
	        userBeans.add(userBean1);  
	        userBeans.add(userBean2);  
	        userBeans.add(userBean3);  
	          
	        DeptBeanDate deptBean = new DeptBeanDate(1, "sanguo", userBeans);  
	        deptBean.setCreateDate(new Date(Calendar.getInstance().getTimeInMillis()));  
	        //实体对象 转json  
	        String userBeanToJson = JacksonUtil.toJSon(userBean1);  
	        String deptBeanToJson = JacksonUtil.toJSon(deptBean);  
	          
	        System.out.println("deptBean to json:" + deptBeanToJson);  
	        System.out.println("userBean to json:" + userBeanToJson);  
	          
	        //json 转实体对象  
	        UserBeanDate jsonToUserBean = JacksonUtil.readValue(userBeanToJson, UserBeanDate.class);  
	        DeptBeanDate jsonToDeptBean = JacksonUtil.readValue(deptBeanToJson, DeptBeanDate.class);  
	          
	        System.out.println("json to DeptBeanDate" + jsonToDeptBean.toString());  
	        System.out.println("json to UserBeanDate" + jsonToUserBean.toString());  
	          
	        //List 转json  
	        String listToJson = JacksonUtil.toJSon(userBeans);  
	        System.out.println("list to json:" + listToJson);  
	          
	        //json 转 List  
	        List<UserBeanDate> jsonToUserBeans = JacksonUtil.readValue(listToJson, new TypeReference<List<UserBeanDate>>() {  
	        });  
	        String userBeanString = "";  
	        for (UserBeanDate userBean : jsonToUserBeans) {  
	            userBeanString += userBean.toString() + "\n";  
	        }  
	        System.out.println("json to userBeans:" + userBeanString);  
	}
}
