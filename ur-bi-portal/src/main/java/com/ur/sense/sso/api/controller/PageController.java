package com.ur.sense.sso.api.controller;

import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Throwables;
import com.ur.sense.sso.common.utils.PropertiesUtil;
import com.ur.sense.sso.common.utils.RequestUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
@Slf4j
@EnableAutoConfiguration
public class PageController {
	
	public static String TOKEN = "";

	public static long LAST_TOKEN_TIME = 0;

	/**
	 * 微信端获取菜单列表
	 * 
	 * @param request
	 * @return
	 */
	@CrossOrigin
	@RequestMapping("/WeiXin/MenuPage")
	public String menuList(HttpServletRequest request, Model model) {

		log.info("start open Menu Page");
		//token为空或者超过1小时未获取则重新获取token
		if ("".equals(TOKEN) || (LAST_TOKEN_TIME - new Date().getTime()) > 60 * 60 * 1000) {
			// 通过CORPID与CORPSECRET获取Token
			String corpid = PropertiesUtil.getProperty("CORPID");
			String corpsecret = PropertiesUtil.getProperty("CORPSECRET");

			String token_url = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=" + corpid + "&corpsecret="
					+ corpsecret;
			String resultToken = RequestUtil.get(token_url);
			log.info("weixin token json ---> {} ", resultToken);
			try {
				JSONObject json = JSONObject.parseObject(resultToken);
				TOKEN = json.getString("access_token");
				LAST_TOKEN_TIME = new Date().getTime();
			} catch (Exception e) {
				log.error("DataController--->/WeiXin/MenuPage json format resultToken error: {}", Throwables.getStackTraceAsString(e));
			}
		}
		// 企业微信访问时携带的code，需要通过code获取userid
		String code = request.getParameter("code");
		log.info("code ---> {} ", code);
		//code为空则表示非企业微信访问,则返回错误页面
    	if(code == null || "".equals(code)) {
    		return "access_error";
    	}

		String user_url = "https://qyapi.weixin.qq.com/cgi-bin/user/getuserinfo?access_token="+TOKEN+"&code="+code;

		String resultUser = RequestUtil.get(user_url);
		log.info("resultUser json ----> {}", resultUser);
		String userId = "";
		try {
			JSONObject json = JSONObject.parseObject(resultUser);
			userId = json.getString("UserId");
		} catch (Exception e) {
			log.error("DataController--->/WeiXin/MenuPage json format resultUser error: {}", Throwables.getStackTraceAsString(e));
		}
    	if(userId == null || "".equals(userId)) {
    		return "access_error";
    	}

    	//将userid返回到前台,进行下一次请求
		model.addAttribute("userId", userId);
		return "index";
	}
}
