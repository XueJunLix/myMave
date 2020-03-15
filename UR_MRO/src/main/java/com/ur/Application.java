package com.ur;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ur.common.service.LocalLanguageService;
import com.ur.fw.common.rest.CommonRestResponse;

@SpringBootApplication 
@ServletComponentScan
@EnableCaching
@Controller
@EnableAsync   //开启异步功能
public class Application{
	
	@Autowired
	LocalLanguageService languageService;
	
	protected static Logger logger=LoggerFactory.getLogger(Application.class);

    @RequestMapping("/")
    @ResponseBody
    String home() {
    	Date dt = new Date();
		System.err.println("=====dt=" + dt.getTime());
    	System.out.println("index");
        return "Index不验证哦" + dt.getTime();
    } 
    
    
    @RequestMapping("/demo")
    public String TemplateDemo() {
        return "demo";
    }  
    
    @RequestMapping("/hello")
    @ResponseBody
    String hello() {
    	System.out.println("hello");
        return "hello";
    }
    
    @RequestMapping("/session/invalid")
    String sessionInvalid() {
    	System.out.println("session invalid");
        return "sessionInvalid";
    }
	
    @RequestMapping("/login")
    public String login() {
    	System.err.println("=====login======");
        return "login";
    }  
    
    
    @RequestMapping("/logout")
    public String loginOut(HttpSession session, HttpServletRequest request,
	    HttpServletResponse response, ModelMap modelMap) throws Exception {
	    session.removeAttribute("musersession");
	    session.removeAttribute("_const_cas_assertion_"); //单点登录的session值去除
//	    session.removeAttribute(Constants.USER_INFO);
//	    session.removeAttribute(Constants.sessionFactory);
	    session.invalidate();
	    logger.info("==登陆超时，重新返回首页");
	    
	    return "login";
	
	    //单点登录登出
//	    String logout_url = cas_server_logout_url + "?service=" + app_login_url;
//	    response.sendRedirect(logout_url);
	
	    //return new ModelAndView("/pages/login.jsp"); //spring-boot会自动去src/main/webapp/pages下面找home.html这个文件
    }    
    
    @RequestMapping(value="TemplateDemo",method = RequestMethod.GET)
    public String ConfigNonParticipationList(Model model) {
		 return "TemplateDemo"; 
    }
    
    @RequestMapping("/getLocalLanguage")
	@ResponseBody
	CommonRestResponse getLocalLanguage(HttpServletRequest request,HttpServletResponse resp) {
		String language = languageService.getLocaleLanguage();
		logger.debug("=========================getLocalLanguage:"+language);
		return new CommonRestResponse(CommonRestResponse.SUCCESS_FLAG,language,language);
	}
    
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
//	@Bean
//	@LoadBalanced
//	RestTemplate restTemplate() {
//		return new RestTemplate();
//	}

}
