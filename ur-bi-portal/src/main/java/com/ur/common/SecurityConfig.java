package com.ur.common;

import org.jasig.cas.client.session.SingleSignOutFilter;
import org.jasig.cas.client.validation.Cas20ServiceTicketValidator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.cas.ServiceProperties;
import org.springframework.security.cas.authentication.CasAssertionAuthenticationToken;
import org.springframework.security.cas.authentication.CasAuthenticationProvider;
import org.springframework.security.cas.web.CasAuthenticationEntryPoint;
import org.springframework.security.cas.web.CasAuthenticationFilter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

import com.ur.common.CustomUserDetailsService;

@Configuration
@EnableWebSecurity //启用web权限
@EnableGlobalMethodSecurity(prePostEnabled = true) //启用方法验证
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Value("${cas.server.host.url}")
	private String casServerUrl;

	@Value("${cas.server.host.login_url}")
	private String casServerLoginUrl;

	@Value("${cas.server.host.logout_url}")
	private String casServerLogoutUrl;

	@Value("${app.server.host.url}")
	private String appServerUrl;

	@Value("${app.login.url}")
	private String appLoginUrl;

	@Value("${app.logout.url}")
	private String appLogoutUrl;	
	
	/**定义认证用户信息获取来源，密码校验规则等*/
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		super.configure(auth);
		auth.authenticationProvider(casAuthenticationProvider());
		//inMemoryAuthentication 从内存中获取
		//auth.inMemoryAuthentication().withUser("chengli").password("123456").roles("USER")
		//.and().withUser("admin").password("123456").roles("ADMIN");
		
		//jdbcAuthentication从数据库中获取，但是默认是以security提供的表结构
		//usersByUsernameQuery 指定查询用户SQL
		//authoritiesByUsernameQuery 指定查询权限SQL
		//auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery(query).authoritiesByUsernameQuery(query);
		
		//注入userDetailsService，需要实现userDetailsService接口
		//auth.userDetailsService(userDetailsService);
	}
	
	/**定义安全策略*/
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		
		http.headers().frameOptions().disable();
		
		http.authorizeRequests()//配置安全策略
     		.antMatchers("/","/**","/WeiXin/getUser","/test","/js","/WeiXin/getMenuList","/css","/WeiXin/MenuPage","/WeiXin/openPage","/getUserInfoByLoginId","/getMenuByRootCode","/getMenuByLoginIdAndRootCode").permitAll()//定义/请求不需要验证
     		//.antMatchers("/","/resources/*","/WeiXin/getUser","/test","/js","/WeiXin/getMenuList","/css","/WeiXin/MenuPage","/WeiXin/openPage","/getUserInfoByLoginId","/getMenuByRootCode","/getMenuByLoginIdAndRootCode").permitAll()//定义/请求不需要验证
			.anyRequest().authenticated()//其余的所有请求都需要验证
			.and().logout().permitAll()//定义logout不需要验证
			.and().formLogin()//使用form表单登录
		.and()
		.csrf().disable();
		//.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()); //Adding the CSRF Token in the Client
		
		http.exceptionHandling().authenticationEntryPoint(casAuthenticationEntryPoint())
			.and()
			.addFilter(casAuthenticationFilter())
			.addFilterBefore(casLogoutFilter(), LogoutFilter.class)
			.addFilterBefore(singleSignOutFilter(), CasAuthenticationFilter.class);
		
		//http.csrf().disable(); //禁用CSRF
	}
	
	/**认证的入口*/
	@Bean
	public CasAuthenticationEntryPoint casAuthenticationEntryPoint() {
		CasAuthenticationEntryPoint casAuthenticationEntryPoint = new CasAuthenticationEntryPoint();
		casAuthenticationEntryPoint.setLoginUrl(casServerLoginUrl);
		casAuthenticationEntryPoint.setServiceProperties(serviceProperties());
		return casAuthenticationEntryPoint;
	}
	
	/**指定service相关信息*/
	@Bean
	public ServiceProperties serviceProperties() {
		ServiceProperties serviceProperties = new ServiceProperties();
		serviceProperties.setService(appServerUrl + appLoginUrl);
		serviceProperties.setAuthenticateAllArtifacts(true);
		return serviceProperties;
	}
	
	/**CAS认证过滤器*/
	@Bean
	public CasAuthenticationFilter casAuthenticationFilter() throws Exception {
		CasAuthenticationFilter casAuthenticationFilter = new CasAuthenticationFilter();
		casAuthenticationFilter.setAuthenticationManager(authenticationManager());
		casAuthenticationFilter.setFilterProcessesUrl(appLoginUrl);
		return casAuthenticationFilter;
	}
	
	/**cas 认证 Provider*/
	@Bean
	public CasAuthenticationProvider casAuthenticationProvider() {
		CasAuthenticationProvider casAuthenticationProvider = new CasAuthenticationProvider();
		casAuthenticationProvider.setAuthenticationUserDetailsService(customUserDetailsService());
		//casAuthenticationProvider.setUserDetailsService(customUserDetailsService()); //这里只是接口类型，实现的接口不一样，都可以的。
		casAuthenticationProvider.setServiceProperties(serviceProperties());
		casAuthenticationProvider.setTicketValidator(cas20ServiceTicketValidator());
		casAuthenticationProvider.setKey("casAuthenticationProviderKey");
		return casAuthenticationProvider;
	}
	
	/*@Bean
	public UserDetailsService customUserDetailsService(){
		return new CustomUserDetailsService();
	}*/
	
	/**用户自定义的AuthenticationUserDetailsService*/
	@Bean
	public AuthenticationUserDetailsService<CasAssertionAuthenticationToken> customUserDetailsService(){
		return new CustomUserDetailsService();
	}
	
	@Bean
	public Cas20ServiceTicketValidator cas20ServiceTicketValidator() {
		return new Cas20ServiceTicketValidator(casServerUrl);
	}
	
	/**单点登出过滤器*/
	@Bean
	public SingleSignOutFilter singleSignOutFilter() {
		SingleSignOutFilter singleSignOutFilter = new SingleSignOutFilter();
		singleSignOutFilter.setCasServerUrlPrefix(casServerUrl);
		singleSignOutFilter.setIgnoreInitConfiguration(true);
		return singleSignOutFilter;
	}
	
	/**请求单点退出过滤器*/
	@Bean
	public LogoutFilter casLogoutFilter() {
		LogoutFilter logoutFilter = new LogoutFilter(casServerLogoutUrl, new SecurityContextLogoutHandler());
		logoutFilter.setFilterProcessesUrl(appLogoutUrl);
		return logoutFilter;
	}
	
}