package ltd.zndo.oss.admin.commons.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 登录密码工具
 * 
 * @author tianxin<tianxin@weconex.com>
 * @created 2018/01/01 9:00
 * @modified 2018/01/01 9:30
 * @since
 * @since JDK 1.8
 *
 */
public class PasswordUtil {

	public static final PasswordEncoder encoder = new BCryptPasswordEncoder();

	/**
	 * 加密
	 * 
	 * @param rawPassword
	 *            - 原始密码
	 * @return String - 加密密码
	 */
	public static String encrypt(String rawPassword) {
		return encoder.encode(rawPassword);
	}

	/**
	 * 校验
	 * 
	 * @param rawPassword
	 *            - 原始密码
	 * @param password
	 *            - 匹配密码
	 * @return boolean - 匹配结果
	 */
	public static boolean match(String rawPassword, String password) {
		return encoder.matches(rawPassword, password);
	}

}
