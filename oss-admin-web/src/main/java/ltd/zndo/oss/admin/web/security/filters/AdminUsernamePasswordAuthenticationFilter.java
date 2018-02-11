package ltd.zndo.oss.admin.web.security.filters;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class AdminUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	// 验证码开关
	private boolean isOpenValidateCode = true;

	public static final String VALIDATE_CODE = "validateCode";

	/**
	 * 
	 */
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		if (isOpenValidateCode) {
			checkValidateCode(request);
		}
		return super.attemptAuthentication(request, response);
	}

	/**
	 * 验证码校验
	 * 
	 * @param request
	 */
	protected void checkValidateCode(HttpServletRequest request) {
		HttpSession session = request.getSession();

		String sessionValidateCode = obtainSessionValidateCode(session);
		sessionValidateCode = "1234";// 做个假的验证码；
		// 让上一次的验证码失效
		session.setAttribute(VALIDATE_CODE, null);
		String validateCodeParameter = obtainValidateCodeParameter(request);
		if (StringUtils.isEmpty(validateCodeParameter)
				|| !sessionValidateCode.equalsIgnoreCase(validateCodeParameter)) {
			throw new AuthenticationServiceException("验证码错误！");
		}
	}

	/**
	 * 获取验证码参数
	 * 
	 * @param request
	 * @return
	 */
	private String obtainValidateCodeParameter(HttpServletRequest request) {
		Object obj = request.getParameter(VALIDATE_CODE);
		return null == obj ? "" : obj.toString();
	}

	/**
	 * 获取 Session 验证码
	 * 
	 * @param session
	 * @return
	 */
	protected String obtainSessionValidateCode(HttpSession session) {
		Object obj = session.getAttribute(VALIDATE_CODE);
		return null == obj ? "" : obj.toString();
	}

}