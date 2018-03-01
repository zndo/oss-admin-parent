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

import ltd.zndo.oss.admin.commons.enums.RecordStatus;
import ltd.zndo.oss.admin.commons.enums.UserStatus;
import ltd.zndo.oss.admin.persistence.entity.AdminRole;
import ltd.zndo.oss.admin.persistence.entity.AdminUser;
import ltd.zndo.oss.admin.persistence.mapper.AdminUserMapper;
import ltd.zndo.oss.admin.service.security.ISecurityAuthorityService;
import ltd.zndo.oss.admin.service.security.ISecurityRoleService;
import ltd.zndo.oss.admin.service.security.entity.SecurityUserDetails;
import ltd.zndo.oss.admin.service.security.util.UserFactory;

/**
 * 实现 UserDetailsService 接口
 * 
 * @see org.springframework.security.core.userdetails.UserDetailsService
 * @author admin
 *
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	AdminUserMapper adminUserMapper;

	@Autowired
	ISecurityRoleService securityRoleService;

	@Autowired
	ISecurityAuthorityService securityAuthorityService;

	/**
	 * 根据用户名加载用户<br>
	 * 实现 loadUserByUsername(String username) 方法
	 */
	@Override
	public UserDetails loadUserByUsername(String usernameOrEmailOrPhone) throws UsernameNotFoundException {

		// 数据库管理用户实体
		AdminUser user = null;
		// TODO 缓存取用户
		// SysUsers user = (SysUsers) this.userCache.getUserFromCache(username);

		if (user == null) { // 缓存不存在，再从数据库加载
			AdminUser params = new AdminUser();
			params.setUsername(usernameOrEmailOrPhone);
			params.setDeleted(false);
			user = adminUserMapper.selectOne(params);

			if (user == null) { // 数据库仍不存在
				throw new UsernameNotFoundException(String.format("用户不存在 '%s'.", usernameOrEmailOrPhone));
			}

		}
		if (user.getUserStatus() == UserStatus.DISABLED.getCode()) {
			throw new UsernameNotFoundException(String.format("用户已禁用 '%s'.", usernameOrEmailOrPhone));
		}
		if (user.getUserStatus() == UserStatus.INACTIVE.getCode()) {
			throw new UsernameNotFoundException(String.format("用户未激活 '%s'.", usernameOrEmailOrPhone));
		}
		if (user.getUserStatus() == UserStatus.LOCKED.getCode()) {
			throw new UsernameNotFoundException(String.format("用户已锁定 '%s'.", usernameOrEmailOrPhone));
		}

		// 获取用户的角色
		// List<AdminRole> roles =
		// securityRoleService.loadUserRolesByUsername(usernameOrEmailOrPhone);

		// 获取用户的权限
		Collection<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
		auths = this.securityAuthorityService.loadUserAuthorities(usernameOrEmailOrPhone);

		// TODO 更新缓存

		// 返回安全认证用户详情
		SecurityUserDetails suDetails = new SecurityUserDetails(//
				user.getUsername(), //
				user.getPassword(), //
				auths //
		);
		// suDetails.setAccountNonExpired(true);
		// suDetails.setAccountNonLocked(user.getUserStatus() !=
		// UserStatus.LOCKED.getCode());
		// suDetails.setAuthorities(auths);
		// suDetails.setCredentialsNonExpired(true);
		// suDetails.setEmail(user.getEmail());
		// suDetails.setEnabled(true);
		// suDetails.setId(user.getId());

		return suDetails;
		// return new SecurityUserDetails(auths, user.getEmail(), user.getId(),
		// user.getPassword(), user.getPhone(),
		// user.getUsername());
		// return new User(user.getUsername(), user.getPassword(), auths);

		// /**
		// * @see ltd.zndo.oss.admin.web.security.entity.SecurityUserDetails
		// */
		// return UserFactory.create(user, roles, auths);
	}

}
