package ltd.zndo.oss.admin.persistence.mapper;

import java.util.List;

import ltd.zndo.oss.admin.persistence.base.BaseMapper;
import ltd.zndo.oss.admin.persistence.entity.AdminRole;

public interface AdminRoleMapper extends BaseMapper<AdminRole> {

	/**
	 * 根据用户名加载用户角色
	 * @param username
	 * @return List<AdminRole> - 角色列表
	 */
	List<AdminRole> loadUserRolesByUsername(String username);

}