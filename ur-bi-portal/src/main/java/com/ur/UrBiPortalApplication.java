package com.ur;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.ur.common.service.LocalLanguageService;
import com.ur.fw.common.rest.CommonRestResponse;

@SpringBootApplication
@ServletComponentScan
@EnableCaching
@EnableDiscoveryClient
@Controller
@EnableAsync   //开启异步功能
@Slf4j
public class UrBiPortalApplication {
	@Value("${cas.server.host.url}")
	private String casServerUrl;
	
	@Autowired
	LocalLanguageService languageService;
	
    @RequestMapping("/login")
    public String login() {
        return "login";
    }  
    
    
    @RequestMapping("/logout")
    @ResponseBody
    public String logout(HttpSession session, HttpServletRequest request,
						 HttpServletResponse response, ModelMap modelMap) throws Exception {
	    session.removeAttribute("musersession");
	    session.removeAttribute("_const_cas_assertion_"); //单点登录的session值去除
	    session.invalidate();
	    return "logout";

    }    
    
    @RequestMapping(value="TemplateDemo",method = RequestMethod.GET)
    public String ConfigNonParticipationList(Model model) {
        return "TemplateDemo";
    }
    
    @RequestMapping("/getLocalLanguage")
	@ResponseBody
	CommonRestResponse getLocalLanguage(HttpServletRequest request,HttpServletResponse resp) {
		String language = languageService.getLocaleLanguage();
		log.debug("GetLocalLanguage : {}", language);
		return new CommonRestResponse(CommonRestResponse.SUCCESS_FLAG, language, language);
	}
    
	public static void main(String[] args) {
		SpringApplication.run(UrBiPortalApplication.class, args);
	}
	
	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
