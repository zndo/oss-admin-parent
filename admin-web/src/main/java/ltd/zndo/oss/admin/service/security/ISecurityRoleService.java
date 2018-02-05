package ltd.zndo.oss.admin.service.security;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;

import ltd.zndo.oss.admin.persistence.entity.AdminRole;

public interface ISecurityRoleService {

	/**
	 * // * 加载用户角色
	 * 
	 * @param username
	 * @return
	 */
	@Cacheable()
	List<AdminRole> loadUserRolesByUsername(String username);

}
