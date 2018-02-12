package ltd.zndo.oss.admin.web.controller.rest;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import ltd.zndo.oss.admin.commons.util.UserUtil;
import ltd.zndo.oss.admin.service.security.entity.SecurityUserDetails;

@RestController
public class UserRestController {
	
//	@Autowired
//	private IAdminUserService adminUserService;

	/**
	 * 登录成功 AJAX 响应
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@GetMapping(value = "/signin/success")
	public Map<String, Object> signinSuccess(HttpServletRequest request, HttpServletResponse response) {

//		/**
//		 * 获取来源页面<br>
//		 * 访问来源页面时，未登录情况下跳转到登录页面，登录成功后应返回来源页面
//		 */
//		SavedRequest savedRequest = requestCache.getRequest(request, response);
//		String sourceUrl = "";
//		if (savedRequest != null) {
//			sourceUrl = savedRequest.getRedirectUrl();
//		}
//
//		/**
//		 * 返回数据
//		 */
//		Map<String, Object> result = new HashMap<String, Object>();
//		result.put("code", 0);
//		result.put("message", "登录成功");
//		result.put("status", response.getStatus());
//		result.put("datetime", new Date());
//		if (StringUtils.isNotBlank(sourceUrl)) {
//			result.put("redirect_url", sourceUrl);
//		} else {
//			// 没有来源页面，跳转到仪表盘首页
//			result.put("redirect_url", "/dashboard.html");
//		}
//		return result;
		return null;
	}
	
}
