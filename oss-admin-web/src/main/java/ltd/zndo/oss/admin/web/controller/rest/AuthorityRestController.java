package ltd.zndo.oss.admin.web.controller.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import ltd.zndo.oss.admin.persistence.entity.AdminAuthority;
import ltd.zndo.oss.admin.service.IAdminAuthorityService;

@RestController
public class AuthorityRestController {

	@Autowired
	private IAdminAuthorityService adminAuthorityService;

	/**
	 * 权限列表
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@PostMapping(value = "/authorities")
	public Map<String, Object> users(AdminAuthority params, HttpServletRequest request, HttpServletResponse response) {

		List<AdminAuthority> data = adminAuthorityService.list(params);

		/**
		 * 返回数据
		 */
		Map<String, Object> result = new HashMap<String, Object>();

		Map<String, Object> meta = new HashMap<String, Object>();
		meta.put("page", 1);
		meta.put("pages", 2);
		meta.put("perpage", 10);
		meta.put("total", 15);
		meta.put("sort", "desc");
		meta.put("field", "created");

		// List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
		//
		// int i = 1;
		// while (i < 3) {
		// Map<String, Object> record = new HashMap<String, Object>();
		// record.put("ID", i);
		// record.put("username", "admin");
		// record.put("signinType", "DEFAULT");
		// record.put("nickname", "demo");
		// record.put("avatarUrl", "Welch Group");
		// record.put("gender", "男");
		// record.put("email", "jbutner0@de.vu");
		// record.put("phone", "123456");
		// record.put("userStatus", 1);
		// record.put("meta", "Bosco-Turner");
		// record.put("md5", "AFN");
		// record.put("created","2017-03-17 07:39:53");
		// record.put("updated", "2017-03-17 07:39:53");
		//
		// data.add(record);
		// i++;
		// }

		result.put("meta", meta);
		result.put("data", data);
		return result;
	}

}
