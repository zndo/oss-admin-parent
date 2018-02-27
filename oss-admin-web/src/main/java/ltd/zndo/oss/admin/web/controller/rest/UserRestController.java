package ltd.zndo.oss.admin.web.controller.rest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import ltd.zndo.oss.admin.commons.util.UserUtil;
import ltd.zndo.oss.admin.persistence.entity.AdminUser;
import ltd.zndo.oss.admin.service.IAdminUserService;
import ltd.zndo.oss.admin.service.security.entity.SecurityUserDetails;

@RestController
public class UserRestController {

	@Autowired
	private IAdminUserService adminUserService;

	/**
	 * 登录成功 AJAX 响应
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@PostMapping(value = "/users")
	public Map<String, Object> users(AdminUser params, HttpServletRequest request, HttpServletResponse response) {
		
		
		List<AdminUser> data = adminUserService.list(params);

		/**
		 * 返回数据
		 */
		Map<String, Object> result = new HashMap<String, Object>();

		Map<String, Object> meta = new HashMap<String, Object>();
		meta.put("page", 1);
		meta.put("pages", 1);
		meta.put("perpage", -1);
		meta.put("total", 2);
		meta.put("sort", "asc");
		meta.put("field", "created");

//		List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
//
//		int i = 1;
//		while (i < 3) {
//			Map<String, Object> record = new HashMap<String, Object>();
//			record.put("RecordID", i);
//			record.put("OrderID", "53150-422");
//			record.put("ShipCountry", "AF");
//			record.put("ShipCity", "Qaram Q\\u014dl");
//			record.put("ShipName", "Welch Group");
//			record.put("ShipAddress", "45 Nova Road");
//			record.put("CompanyEmail", "jbutner0@de.vu");
//			record.put("CompanyAgent", "John Butner");
//			record.put("CompanyName", "Bosco-Turner");
//			record.put("Currency", "AFN");
//			record.put("Notes",
//					"platea dictumst morbi vestibulum velit id pretium iaculis diam erat fermentum justo nec condimentum neque sapien");
//			record.put("Department", "Baby");
//			record.put("Website", "dropbox.com");
//			record.put("Latitude", 36.533332999999999);
//			record.put("Longitude", 69.016666999999998);
//			record.put("ShipDate", "5\\/20\\/2017");
//			record.put("PaymentDate", "2017-03-17 07:39:53");
//			record.put("TimeZone", "Asia\\/Kabul");
//			record.put("Status", 4);
//			record.put("Type", 3);
//			record.put("TotalPayment", "80,238.30 AFN");
//
//			data.add(record);
//			i++;
//		}

		result.put("meta", meta);
		result.put("data", data);
		return result;
	}

}
