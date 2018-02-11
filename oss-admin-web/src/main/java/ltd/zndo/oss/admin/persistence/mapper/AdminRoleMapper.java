package ltd.zndo.oss.admin.persistence.mapper;

import java.util.List;

import ltd.zndo.oss.admin.commons.base.AdminBaseMapper;
import ltd.zndo.oss.admin.persistence.entity.AdminRole;
import tk.mybatis.mapper.common.Mapper;

public interface AdminRoleMapper extends AdminBaseMapper, Mapper<AdminRole> {

	/**
	 * 根据用户名加载用户角色
	 * @param username
	 * @return List<AdminRole> - 角色列表
	 */
	List<AdminRole> loadUserRolesByUsername(String username);

}