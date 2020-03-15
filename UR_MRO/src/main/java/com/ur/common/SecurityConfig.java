package com.ur.common;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import com.ur.admin.service.AdminUserInfoService;
import com.ur.admin.user.model.SysUserInfo;
import com.ur.admin.user.service.SysUserInfoService;
import com.ur.common.service.RedisMessageBOService;
import com.ur.fw.common.rest.CommonSearchCondition;

@Configuration
@EnableWebSecurity //启用web权限
@EnableGlobalMethodSecurity(prePostEnabled = true) //启用方法验证
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	/*
	 * //private static final Logger logger =
	 * LoggerFactory.getLogger(SecurityConfig.class);
	 * 
	 * 
	 */
	@Autowired
	AdminUserInfoService adminUserInfoService;
	
	@Autowired
	SysUserInfoService sysUserInfoService;
	
	@Autowired
	RedisMessageBOService redisMessageBOService;
	
	@Value("${server.servlet.session.cookie.name}")
	private String SYSUSERINFO;
	

	@Value("${app.server.host.url}")
	private String appServerUrl;

	@Value("${app.login.url}")
	private String appLoginUrl;

	@Value("${app.logout.url}")
	private String appLogoutUrl;	
	
	/**定义认证用户信息获取来源，密码校验规则等*/
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(getAuthenticationProvider());
	}
	
	/**定义安全策略*/
	@Override
	protected void configure(HttpSecurity http) throws Exception {		
		http.headers().frameOptions().disable();
		
		http.formLogin()//使用form表单登录
				.loginPage("/login")
				.successHandler(new AjaxAuthSuccessHandler())	//登录成功处理器
				.failureHandler(new AjaxAuthFailHandler()) //登录失败处理器
				.and()
			.logout()
				.logoutUrl("/logout")
				.addLogoutHandler(new CustomLogoutHandler())
				.logoutSuccessHandler(new CustomLogoutSuccessHandler())
				.permitAll()//定义logout不需要验证
				.and()
			//.sessionManagement().invalidSessionUrl("/session/invalid")	//会话超时处理地址：用于处理在iframe中出现登录页面（改进方法已在登录页面进行优化，此处暂时作废）
				//.and()
			.authorizeRequests()//配置安全策略
     			.antMatchers("/resources/**","/login","/logout","/session/invalid").permitAll()//定义/请求不需要验证			
     			.anyRequest().authenticated()//其余的所有请求都需要验证
     			.and()
			.csrf().disable();
		
		//认证异常处理
		http.exceptionHandling().authenticationEntryPoint(getAuthenticationEntryPoint());
	}
	
	/** 认证入口点 **/
	@Bean
	public AuthenticationEntryPoint getAuthenticationEntryPoint() {
		LoginUrlAuthenticationEntryPoint point = new LoginUrlAuthenticationEntryPoint(appLoginUrl);
		return point;
	}
	
	
	/**账号登录认证策略**/
	@Bean
	public AbstractUserDetailsAuthenticationProvider getAuthenticationProvider() throws Exception {
		DaoAuthenticationProvider daoProvider = new DaoAuthenticationProvider();
		daoProvider.setUserDetailsService(new CustomUserDetailsService());
		daoProvider.setPasswordEncoder(passwordEncoder());
		return daoProvider;
	}
	
	/** 自定义UserDetailsService **/
	private class CustomUserDetailsService implements UserDetailsService {
		private final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);
		
		@Override
		public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			logger.debug("当前的用户名是："+username);
			
			//根据用户登录账号查找用户
			List<CommonSearchCondition> condList = new ArrayList<CommonSearchCondition>();
			CommonSearchCondition cond = new CommonSearchCondition();
			cond.setBeanName("loginName");
			cond.setColumnName("LOGIN_NAME");
			cond.setOperator("eq");
			cond.setValue(username);
			condList.add(cond);
			List<SysUserInfo> users = sysUserInfoService.searchSysUserInfo(condList, null);
			System.err.println("=========users=:" + users);
			SysUserInfo user = null;
			if(users != null && users.size() > 0) {
				user = users.get(0);
			} else {
				System.err.println("8888888888888");
				throw new UsernameNotFoundException("未找到登录用户！");
			}
			
			System.err.println(user.getLoginName() + "======" + user.getName() + "=====" + user.getPassword());
			
			UserInfo userInfo = new UserInfo();
			userInfo.setUsername(user.getLoginName());
			userInfo.setName(user.getName());
			userInfo.setPassword(user.getPassword());
			
			Set<AuthorityInfo> authorities = new HashSet<AuthorityInfo>();
			AuthorityInfo authorityInfo = new AuthorityInfo("TEST");
			authorities.add(authorityInfo);
			userInfo.setAuthorities(authorities);
			return userInfo;
		}
	}
	
	/**
	 * 	自定义登录成功handler，基于ajax调用
	 */
	private class AjaxAuthSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
		
		private final Logger logger = LoggerFactory.getLogger(AjaxAuthSuccessHandler.class);
		
		@Override
		public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
			logger.debug("AjaxAuthSuccessHandler用户登录成功......");
			try {
				UserInfo u = adminUserInfoService.getCurrentLoginUserInfo();
				String loginId = u.getUsername();
				System.err.println("===loginId=:" + loginId);
				
				//根据登录名获取系统用户信息
				List<CommonSearchCondition> condList = new ArrayList<CommonSearchCondition>();
				CommonSearchCondition cond = new CommonSearchCondition();
				cond.setBeanName("loginName");
				cond.setColumnName("LOGIN_NAME");
				cond.setOperator("eq");
				cond.setValue(loginId);
				condList.add(cond);
				List<SysUserInfo> users = sysUserInfoService.searchSysUserInfo(condList, null);
				SysUserInfo user = null;
				if(users != null && users.size() > 0) {
					user = users.get(0);
				} else {
					throw new UsernameNotFoundException("未找到登录用户！");
				}
				
				//将用户信息放入redis中，对应的key 为登录账号
				redisMessageBOService.addRedis(loginId, user);
				
				//将用户放入服务器会话中
				//request.setAttribute(SYSUSERINFO, user);
				
				response.setContentType("application/json;charset=utf-8");
	            PrintWriter out = response.getWriter();
	            out.write("{\"errcode\":\"ok\",\"errmsg\":\"登录成功\"}");
	            out.flush();
	            out.close();
			} catch (Exception e) {
				System.err.println("==AjaxAuthSuccessHandler==error==");
				
				response.setContentType("application/json;charset=utf-8");
	            PrintWriter out;
				try {
					out = response.getWriter();
					out.write("{\"errcode\":\"no\",\"errmsg\":\""+e.getMessage()+"\"}");
		            out.flush();
		            out.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
	            
				
	            e.printStackTrace();
			}
        }
	}
	
	/**
	 * 	自定义登录失败handler，基于ajax调用
	 */
	private class AjaxAuthFailHandler extends SimpleUrlAuthenticationFailureHandler {
		private final Logger logger = LoggerFactory.getLogger(AjaxAuthFailHandler.class);
		
        @Override
        public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        	logger.debug("AjaxAuthFailHandler用户登录失败......");
        	
            response.setContentType("application/json;charset=utf-8");
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            PrintWriter out = response.getWriter();
            out.write("{\"errcode\":\"no\",\"errmsg\":\"请检查用户名、密码是否正确\"}");
            out.flush();
            out.close();
        }
    }
	
	/** 自定义注销登录处理器 **/
	private class CustomLogoutHandler implements LogoutHandler {
		
		private final Logger logger = LoggerFactory.getLogger(CustomLogoutHandler.class);
				
		@Override
		public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
			logger.debug("自定义注销登录处理器....");
			try {
				UserInfo u = adminUserInfoService.getCurrentLoginUserInfo();
				String loginId = u.getUsername();
				System.err.println("===loginId=:" + loginId);
							
				//将用户信息放入redis中，对应的key 为登录账号
				redisMessageBOService.delRedis(loginId);
				
				//将用户从服务器会话中一处
				//request.removeAttribute(SYSUSERINFO);
				
			} catch (Exception e) {
				System.err.println("==CustomLogoutHandler==error==");
				
				e.printStackTrace();
			}		
		}
	}
	
	/** 自定义注销登录处理器 **/
	private class CustomLogoutSuccessHandler implements LogoutSuccessHandler {
		
		private final Logger logger = LoggerFactory.getLogger(CustomLogoutHandler.class);
				
		@Override
		public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
			logger.debug("自定义注销登录成功处理器....");
			try {
				
				response.setContentType("application/json;charset=utf-8");
	            PrintWriter out = response.getWriter();
	            out.write("{\"errcode\":\"ok\",\"errmsg\":\"登出成功\"}");
	            out.flush();
	            out.close();
			} catch (Exception e) {
				System.err.println("==CustomLogoutSuccessHandler==error==");
				
				response.setContentType("application/json;charset=utf-8");
	            PrintWriter out;
				try {
					out = response.getWriter();
					out.write("{\"errcode\":\"no\",\"errmsg\":\""+e.getMessage()+"\"}");
		            out.flush();
		            out.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				e.printStackTrace();
			}		
		}
	}
	
	
	/** 自定义密码编码认证 **/
	@Bean
	public Md5PasswordEncoder  passwordEncoder() {
		return new Md5PasswordEncoder();
	}
}