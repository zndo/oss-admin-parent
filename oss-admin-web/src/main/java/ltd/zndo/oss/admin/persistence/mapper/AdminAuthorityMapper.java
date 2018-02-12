package ltd.zndo.oss.admin.persistence.mapper;

import java.util.List;

import ltd.zndo.oss.admin.persistence.base.IBaseMapper;
import ltd.zndo.oss.admin.persistence.entity.AdminAuthority;

public interface AdminAuthorityMapper extends IBaseMapper<AdminAuthority> {
	
	/**
	 * 根据用户名加载用户权限
	 * 
	 * @param username
	 * @return List<AdminAuthority> - 权限列表
	 */
	List<AdminAuthority> loadUserAuthoritiesByUsername(String username);
	
}