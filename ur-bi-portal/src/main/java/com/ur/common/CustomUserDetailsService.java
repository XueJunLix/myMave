package com.ur.common;

import java.util.HashSet;
import java.util.Set;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.cas.authentication.CasAssertionAuthenticationToken;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * 用于加载用户信息 实现UserDetailsService接口，或者实现AuthenticationUserDetailsService接口
 *
 */
@Slf4j
public class CustomUserDetailsService implements AuthenticationUserDetailsService<CasAssertionAuthenticationToken> {

	public UserDetails loadUserDetails(CasAssertionAuthenticationToken token) throws UsernameNotFoundException {
		log.debug("当前的用户名是：{}, 用户属性：{}, 用户权限：{}, 用户detail：{}",
				token.getAssertion().getPrincipal().getName(),
				token.getAssertion().getPrincipal().getAttributes(),
				token.getAuthorities(),
				token.getDetails());

		/*这里我为了方便，就直接返回一个用户信息，实际当中这里修改为查询数据库或者调用服务什么的来获取用户信息*/
		UserInfo userInfo = new UserInfo();
		userInfo.setUsername(token.getAssertion().getPrincipal().getName());
		userInfo.setName(token.getAssertion().getPrincipal().getName());
		Set<AuthorityInfo> authorities = new HashSet<AuthorityInfo>();
		AuthorityInfo authorityInfo = new AuthorityInfo("ACTUATOR");
		authorities.add(authorityInfo);
		userInfo.setAuthorities(authorities);
		return userInfo;
	}
}
