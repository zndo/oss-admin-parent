package ltd.zndo.oss.admin.service.security.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import ltd.zndo.oss.admin.persistence.entity.AdminRole;
import ltd.zndo.oss.admin.persistence.mapper.AdminRoleMapper;
import ltd.zndo.oss.admin.service.security.ISecurityRoleService;

@Service
public class SecurityRoleServiceImpl implements ISecurityRoleService{

	@Autowired
	private AdminRoleMapper adminRoleMapper;
	
	/**
	 * 根据用户名加载用户角色
	 * 
	 * @param username
	 * @return List<AdminRole> - 角色列表
	 */
    @Cacheable()
	public List<AdminRole> loadUserRolesByUsername(String username) {
		
		List<AdminRole> adminRoles = adminRoleMapper.loadUserRolesByUsername(username);
		return adminRoles;
	}
}
