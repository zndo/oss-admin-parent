package ltd.zndo.oss.admin.commons.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import ltd.zndo.oss.admin.service.security.entity.SecurityUserDetails;

public class UserUtil {

	/**
	 * 获取当前用户信息
	 * 
	 * @return
	 */
	public static SecurityUserDetails currentUser() {
		SecurityUserDetails user = null;
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Object principal = null;
		if (authentication != null) {
			principal = authentication.getPrincipal();
		}
		if (principal != null && principal instanceof SecurityUserDetails) {
			user = (SecurityUserDetails) principal;
		}
		return user;
	}

}
