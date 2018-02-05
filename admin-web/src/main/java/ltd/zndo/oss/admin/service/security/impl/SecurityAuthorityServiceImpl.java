package ltd.zndo.oss.admin.service.security.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import ltd.zndo.oss.admin.persistence.entity.AdminAuthority;
import ltd.zndo.oss.admin.persistence.mapper.AdminAuthorityMapper;
import ltd.zndo.oss.admin.service.security.ISecurityAuthorityService;

@Service
public class SecurityAuthorityServiceImpl implements ISecurityAuthorityService{

	@Autowired
	private AdminAuthorityMapper adminAuthorityMapper;

	/**
	 * 加载用户权限
	 * 
	 * @param username
	 * @return
	 */
	public Collection<GrantedAuthority> loadUserAuthorities(String username) {

		List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();

		List<AdminAuthority> adminAuthorities = this.loadUserAuthoritiesByUsername(username);
		for (AdminAuthority authority : adminAuthorities) {
			GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authority.getAuthority());
			auths.add(grantedAuthority);
		}

		return auths;
	}

	/**
	 * 根据用户名加载用户权限
	 * 
	 * @param username
	 * @return
	 */
	private List<AdminAuthority> loadUserAuthoritiesByUsername(String username) {

		List<AdminAuthority> adminAuthorities = adminAuthorityMapper.loadUserAuthoritiesByUsername(username);
		return adminAuthorities;
	}
}
