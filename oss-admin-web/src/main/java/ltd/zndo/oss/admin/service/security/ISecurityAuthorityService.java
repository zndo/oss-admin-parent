package ltd.zndo.oss.admin.service.security;

import java.util.Collection;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.GrantedAuthority;

public interface ISecurityAuthorityService {

	/**
	 * 加载用户权限
	 * @param username
	 * @return
	 */
    @Cacheable()
	Collection<GrantedAuthority> loadUserAuthorities(String username);
	
}
