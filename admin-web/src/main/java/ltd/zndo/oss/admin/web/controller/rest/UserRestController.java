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

	private RequestCache requestCache = new HttpSessionRequestCache();

	/**
	 * 登录成功 AJAX 响应
	 * @param request
	 * @param response
	 * @return
	 */
	@GetMapping(value = "/signin/success")
	public Map<String, Object> signinSuccess(HttpServletRequest request, HttpServletResponse response) {

		/**
		 * 获取来源页面<br>
		 * 访问来源页面时，未登录情况下跳转到登录页面，登录成功后应返回来源页面
		 */
		SavedRequest savedRequest = requestCache.getRequest(request, response);
		String sourceUrl = "";
		if (savedRequest != null) {
			sourceUrl = savedRequest.getRedirectUrl();
		}

		/**
		 * 获取认证消息
		 */
		AuthenticationException authException = (AuthenticationException) request.getSession()
				.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);

		/**
		 * 返回数据
		 */
		// private String code; // 业务代码
		// private String msg; // 业务消息
		// private int status; // HTTP 状态代码
		// private long timestamp; // 时间戳
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", 0);
		result.put("message", authException.getMessage());
		result.put("status", response.getStatus());
		result.put("datetime", new Date());
		if (StringUtils.isNotBlank(sourceUrl)) {
			result.put("redirect_url", sourceUrl);
		} else {
			// 没有来源页面，跳转到仪表盘首页
			result.put("redirect_url", "/dashboard.html");
		}
		return result;
	}

	// @GetMapping(value = "/signin/failure")
	// public Map<String, Object> loginFailure(HttpServletRequest request,
	// HttpServletResponse response) {
	// AuthenticationException ae = (AuthenticationException) request.getSession()
	// .getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
	// Map<String, Object> result = new HashMap<String, Object>();
	// result.put("success", false);
	// result.put("message", ae.getMessage());
	// return result;
	// }

	@GetMapping(value = "/security/user")
	public Map<String, Object> securityUser(HttpServletRequest request) {
		SecurityUserDetails user = UserUtil.currentUser();
		Map<String, Object> result = new HashMap<String, Object>();
		StringBuilder userRole = new StringBuilder();
		if (user != null) {
			result.put("userId", user.getId());
			result.put("userName", user.getUsername());
			Collection<? extends GrantedAuthority> roleLst = user.getAuthorities();
			for (GrantedAuthority sga : roleLst) {
				userRole.append(sga.toString() + "; ");
			}
		}
		result.put("userRole", userRole.toString());
		result.put("message", "This message is only visible to the user");
		return result;
	}

	@GetMapping(value = "/security/admin")
	public Map<String, Object> securityAdmin(HttpServletRequest request) {
		SecurityUserDetails user = UserUtil.currentUser();
		Map<String, Object> result = new HashMap<String, Object>();
		StringBuilder userRole = new StringBuilder();
		if (user != null) {
			result.put("userId", user.getId());
			result.put("userName", user.getUsername());
			Collection<? extends GrantedAuthority> roleLst = user.getAuthorities();
			for (GrantedAuthority sga : roleLst) {
				userRole.append(sga.toString() + "; ");
			}
		}
		result.put("userRole", userRole.toString());
		result.put("message", "This message is only visible to the admin");
		return result;
	}

	@GetMapping(value = "/user/account")
	public Map<String, Object> getUserAcctunt(HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("message", "需要进行完整认证的请求（不是通过Remember-me功能进行的认证）");
		return result;
	}

}
