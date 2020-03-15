package com.ur.sense.sso.api.controller;

import com.google.common.base.Throwables;
import com.ur.sense.sso.common.utils.PropertiesUtil;
import com.ur.sense.sso.common.utils.TokenServiceUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
@EnableAutoConfiguration
public class UserController {
	/**
	 * PC端跳转
	 * @param request
	 * @return
	 */
	@RequestMapping("/SenseRedirect")
	public String SenseRedirect(HttpServletRequest request) {

		try {
			String userid = request.getUserPrincipal().getName();
			log.info("current login user: {}", userid);

			String redirectSenseUrl = request.getParameter("redirectUrl");
			log.info("redirectSenseUrl ---> {}", redirectSenseUrl);
			//若无指定Sense链接地址，则取配置文件中配置的默认地址
			if (Strings.isBlank(redirectSenseUrl)) {
				String senseServer = PropertiesUtil.getProperty("SenseServer");
				redirectSenseUrl = senseServer;
			}

			//通过userid获取Ticket
			TokenServiceUtil tsu = new TokenServiceUtil();
			String senseTicket = tsu.getTicket(userid);

			log.info("senseTicket: {}", senseTicket);
			//若ticket为空，则表明用户不存在或sense服务器4243端口访问不成功
			if ("".equals(senseTicket)) {
				String errorPage = PropertiesUtil.getProperty("ErrorPage");
				return "redirect:" + errorPage;
			}
			String redirectUrl = redirectSenseUrl + "?qlikTicket=" + senseTicket;
			return "redirect:" + redirectUrl;
		} catch (Exception e) {
			log.error("SenseRedirect error: {}", Throwables.getStackTraceAsString(e));
		}

		String ErrorPage = PropertiesUtil.getProperty("ErrorPage");
		return "redirect:" + ErrorPage;
	}

	/**
	 * 微信端跳转
	 * 
	 * @param request
	 * @return
	 */
	@CrossOrigin
	@RequestMapping("/WeiXin/openPage")
	public String openPage(HttpServletRequest request) {
		log.debug("start openPage");
		String url = request.getParameter("url");
		log.debug("url ---> {}", url);
		String userId = request.getParameter("userId");
		//若userid或url为空则返回错误页面
		if (Strings.isBlank(userId) || Strings.isBlank(url)) {
			String errorPage = PropertiesUtil.getProperty("ErrorPage");
			return "redirect:" + errorPage;
		}
		//每次访问sense菜单都需要重新获取ticket
		TokenServiceUtil tsu = new TokenServiceUtil();
		String senseTicket = tsu.getTicket(userId);
		log.info("senseTicket: {}", senseTicket);
		//若ticket为空，则表明用户不存在或sense服务器4243端口访问不成功
		if ("".equals(senseTicket)) {
			String errorPage = PropertiesUtil.getProperty("ErrorPage");
			return "redirect:" + errorPage;
		}
		String redirectUrl = url + "?qlikTicket=" + senseTicket;
		return "redirect:" + redirectUrl;
	}

}
