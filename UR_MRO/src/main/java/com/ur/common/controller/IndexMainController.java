package com.ur.common.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ur.admin.user.model.SysUserInfo;
import com.ur.admin.user.service.SysUserInfoService;
import com.ur.common.UserInfo;
import com.ur.common.service.BaseService;
import com.ur.common.service.IndexMainService;
import com.ur.fw.common.rest.CommonSearchCondition;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONArray;

@Controller
@RequestMapping(value = "/main")
@Api(description = "index的注释")
public class IndexMainController {
	
	@Autowired
	BaseService baseService;
	
	@Autowired
	IndexMainService indexMainService;
	
	@Autowired
	SysUserInfoService userService;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	@ApiOperation(value = "index默认页面模板", notes = "index默认页面模板")
	public synchronized String index(Model model) {	
		 
		UserInfo user = baseService.getCurrentLoginUserInfo();
		System.err.println("===userName="+user.getUsername()+"======userId=" + user.getId());
		
		List<CommonSearchCondition> condList = new ArrayList<CommonSearchCondition>();
		CommonSearchCondition cond = new CommonSearchCondition();
		cond.setBeanName("loginName");
		cond.setColumnName("LOGIN_NAME");
		cond.setOperator("eq");
		cond.setValue(user.getUsername());
		condList.add(cond);
		
		SysUserInfo su = userService.searchSysUserInfo(condList, null).get(0);
		model.addAttribute("currUser", su);
		
		JSONArray menuArray = indexMainService.getMenusByCurrUser(su);
		model.addAttribute("menus",menuArray);
		
		return "indexmain";
		//return "mro/mat/MROnav";
	}
}
