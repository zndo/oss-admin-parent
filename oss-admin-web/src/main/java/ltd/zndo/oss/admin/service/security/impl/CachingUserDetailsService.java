package ltd.zndo.oss.admin.service.security.impl;

import org.springframework.security.core.userdetails.UserCache;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.cache.NullUserCache;
import org.springframework.util.Assert;

/**
 * 用户缓存
 * 
 * @author admin
 *
 */
public class CachingUserDetailsService implements UserDetailsService {

	private final UserDetailsService delegate;

	CachingUserDetailsService(UserDetailsService delegate) {
		this.delegate = delegate;
	}

	private UserCache userCache = new NullUserCache();

	public UserCache getUserCache() {
		return userCache;
	}

	public void setUserCache(UserCache userCache) {

		this.userCache = userCache;

	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		UserDetails user = userCache.getUserFromCache(username);

		if (user == null) {
			user = delegate.loadUserByUsername(username);
		}

		Assert.notNull(user, "UserDetailsService " + delegate + " returned null for username " + username + ". " +

				"This is an interface contract violation");

		userCache.putUserInCache(user);

		return user;

	}

}
