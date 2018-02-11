package ltd.zndo.oss.admin.persistence.mapper;

import java.util.List;
import java.util.Map;

import ltd.zndo.oss.admin.persistence.base.BaseMapper;
import ltd.zndo.oss.admin.persistence.entity.AdminResource;

public interface AdminResourceMapper extends BaseMapper<AdminResource> {

	/**
	 * 加载资源映射
	 * 
	 * @return List<Map<String, String>> - 资源映射列表
	 */
	List<Map<String, String>> loadResourcesMapping();

}