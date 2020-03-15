package com.ur.admin.service;

import com.ur.common.UserInfo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AdminUserInfoService {
    
    public UserInfo getCurrentLoginUserInfo() {
    	if(SecurityContextHolder.getContext()!=null && SecurityContextHolder.getContext().getAuthentication()!=null
    			 && SecurityContextHolder.getContext().getAuthentication().getPrincipal()!=null) {
        	return (UserInfo) SecurityContextHolder.getContext() 
        			.getAuthentication() 
        			.getPrincipal(); 
    	}else {
    		return null;
    	}
    }
    
    public String getCurrentLoginUserName() {
    	String userName="none";
    	UserInfo userInfo = this.getCurrentLoginUserInfo();
    	if(userInfo!=null) {
    		userName=userInfo.getUsername();
    		userName = userName.trim();
    	}
    	return userName;
    }

	public String getCurrentLoginName() {
		String userName="none";
		UserInfo userInfo = this.getCurrentLoginUserInfo();
		if(userInfo!=null) {
			userName=userInfo.getUsername();
			userName = userName.trim();
		}
		return userName;
	}

}