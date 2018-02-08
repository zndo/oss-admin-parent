package ltd.zndo.oss.admin.service.security.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ltd.zndo.oss.admin.commons.enums.UserStatus;
import ltd.zndo.oss.admin.persistence.entity.AdminRole;
import ltd.zndo.oss.admin.persistence.entity.AdminUser;
import ltd.zndo.oss.admin.persistence.mapper.AdminUserMapper;
import ltd.zndo.oss.admin.service.security.ISecurityAuthorityService;
import ltd.zndo.oss.admin.service.security.ISecurityRoleService;
import ltd.zndo.oss.admin.web.security.UserFactory;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
    AdminUserMapper adminUserMapper;

	@Autowired
	ISecurityRoleService securityRoleService;

	@Autowired
	ISecurityAuthorityService securityAuthorityService;

	/**
	 * 根据用户名加载用户
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		// 数据库管理用户实体
		AdminUser user = null;
		// TODO 缓存取用户
		// SysUsers user = (SysUsers) this.userCache.getUserFromCache(username);

		if (user == null) { // 缓存不存在，再从数据库加载
			AdminUser params = new AdminUser();
			params.setUsername(username);
			params.setDeleted(false);
			user = adminUserMapper.selectOne(params);

			if (user == null) { // 数据库仍不存在
				throw new UsernameNotFoundException(String.format("用户不存在 '%s'.", username));
			}

		}
		if (user.getUserStatus().equals(UserStatus.DISABLED.getCode())) {
			throw new UsernameNotFoundException(String.format("用户已禁用 '%s'.", username));
		}
		if (user.getUserStatus().equals(UserStatus.INACTIVE.getCode())) {
			throw new UsernameNotFoundException(String.format("用户未激活 '%s'.", username));
		}

		// 获取用户的角色
		List<AdminRole> roles = securityRoleService.loadUserRolesByUsername(username);

		// 获取用户的权限
		Collection<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
		auths = this.securityAuthorityService.loadUserAuthorities(username);
		
		// TODO 更新缓存
		
		return new User(user.getUsername(), user.getPassword(), auths);
		
//		/**
//		 * @see ltd.zndo.oss.admin.web.security.entity.SecurityUserDetails
//		 */
//		return UserFactory.create(user, roles, auths);
	}

}
