package ltd.zndo.oss.admin.service.security.impl;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

/**
 * 访问决策管理器<br>
 * 用来对用户的角色和资源的访问权限进行匹配 实现 AccessDecisionManager 接口<br>
 * 
 * @see org.springframework.security.access.AccessDecisionManager
 * @author admin
 *
 */
@Service
public class AdminAccessDecisionManager implements AccessDecisionManager {

	protected final Log logger = LogFactory.getLog(getClass());

	// 决策方法判定是否拥有权限，权限匹配则放行，否则抛出访问拒绝异常或权限不足异常
	// authentication 是释CustomUserService中循环添加到 GrantedAuthority 对象中的权限信息集合.
	// object 包含客户端发起的请求的requset信息，可转换为 HttpServletRequest request =
	// ((FilterInvocation) object).getHttpRequest();
	// configAttributes 为MyInvocationSecurityMetadataSource的getAttributes(Object
	// object)这个方法返回的结果，此方法是为了判定用户请求的url 是否在权限表中，如果在权限表中，则返回给 decide
	// 方法，用来判定用户是否有此权限。如果不在权限表中则放行。
	@Override
	public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes)
			throws AccessDeniedException, InsufficientAuthenticationException {

		if (null == configAttributes || configAttributes.size() == 0) {
			return;
		}

		// 从认证信息中获取授权
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

		// 权限判定
		String needRole;
		for (ConfigAttribute cfg : configAttributes) {
			needRole = cfg.getAttribute().trim(); // 访问资源需要的角色
			// 遍历已登录用户的权限集合
			for (GrantedAuthority ga : authorities) {
				// 权限匹配
				if (needRole.equals(ga.getAuthority())) {
					return; // 放行该请求
				}
			}
		}

		logger.info("权限验证失败");
		throw new AccessDeniedException("没有访问权限");
	}

	@Override
	public boolean supports(ConfigAttribute cfg) {
		return true;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

}
