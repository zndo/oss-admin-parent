package ltd.zndo.oss.admin.web.security.entity;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 安全认证用户实体类
 * 
 * @author zndo
 *
 */
public class User implements UserDetails {

	/**
	 * SerialVersionUID
	 */
	private static final long serialVersionUID = -2370978319174748374L;

	// 角色
	private final Collection<? extends GrantedAuthority> authorities;

	private boolean accountNonExpired;

	private boolean accountNonLocked;

	private boolean credentialsNonExpired;

	private boolean enabled;

	// ID
	private final String id;

	// 密码
	private final String password;

	// 用户名
	private final String username;

	// Constructors

	/**
	 * 构造方法-半参
	 * 
	 * @param id
	 * @param username
	 * @param password
	 * @param authorities
	 */
	public User(Collection<? extends GrantedAuthority> authorities, String id, String password, String username) {
		super();
		this.authorities = authorities;
		this.id = id;
		this.password = password;
		this.username = username;
	}

	/**
	 * 构造方法-全参
	 * 
	 * @param authorities
	 * @param accountNonExpired
	 * @param accountNonLocked
	 * @param credentialsNonExpired
	 * @param enabled
	 * @param id
	 * @param password
	 * @param username
	 */
	public User(Collection<? extends GrantedAuthority> authorities, boolean accountNonExpired, boolean accountNonLocked,
			boolean credentialsNonExpired, boolean enabled, String id, String password, String username) {
		super();
		this.authorities = authorities;
		this.accountNonExpired = accountNonExpired;
		this.accountNonLocked = accountNonLocked;
		this.credentialsNonExpired = credentialsNonExpired;
		this.enabled = enabled;
		this.id = id;
		this.password = password;
		this.username = username;
	}

	// Getters & Setters

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	@Override
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	@Override
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

	public String getId() {
		return id;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

}
