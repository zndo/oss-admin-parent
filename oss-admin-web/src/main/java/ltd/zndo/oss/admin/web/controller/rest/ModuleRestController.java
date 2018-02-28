package ltd.zndo.oss.admin.web.controller.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import ltd.zndo.oss.admin.persistence.entity.AdminModule;
import ltd.zndo.oss.admin.service.IAdminModuleService;

@RestController
public class ModuleRestController {

	@Autowired
	private IAdminModuleService adminModuleService;

	/**
	 * 模块列表
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@PostMapping(value = "/modules")
	public Map<String, Object> modules(AdminModule params, HttpServletRequest request, HttpServletResponse response) {

		List<AdminModule> data = adminModuleService.list(params);

		/**
		 * 返回数据
		 */
		Map<String, Object> result = new HashMap<String, Object>();

		Map<String, Object> meta = new HashMap<String, Object>();
		meta.put("page", 1);
		meta.put("pages", 2);
		meta.put("perpage", 10);
		meta.put("total", 15);
		meta.put("sort", "asc");
		meta.put("field", "username");

		result.put("meta", meta);
		result.put("data", data);
		return result;
	}

}
