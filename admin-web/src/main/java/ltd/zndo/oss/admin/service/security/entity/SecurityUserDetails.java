package ltd.zndo.oss.admin.service.security.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 安全认证用户实体类
 * 
 * @author zndo
 *
 */
public class SecurityUserDetails implements UserDetails, Serializable {

	/**
	 * SerialVersionUID
	 */
	private static final long serialVersionUID = -2370978319174748374L;

	private boolean accountNonExpired;

	private boolean accountNonLocked;

	// 角色
	private final Collection<? extends GrantedAuthority> authorities;

	private boolean credentialsNonExpired;

	private boolean enabled;

	// ID
	private final Long id;

	// 密码
	private final String password;

	// 用户名
	private final String username;

	// 用户的角色
//	 @JsonIgnore
//	 private Set<AdminRole> sysUsersRoles = new HashSet<AdminRole>(0);

	// Constructors

//	/**
//	 * 构造方法-半参
//	 * 
//	 * @param id
//	 * @param username
//	 * @param password
//	 * @param authorities
//	 */
//	public SecurityUserDetails(Collection<? extends GrantedAuthority> authorities, String id, String password,
//			String username) {
//		super();
//		this.authorities = authorities;
//		this.id = id;
//		this.password = password;
//		this.username = username;
//	}

	/**
	 * 构造方法-半参
	 * 
	 * @param id
	 * @param password
	 * @param username
	 * @param authorities
	 */
	public SecurityUserDetails(Long id, String password, String username,
			List<GrantedAuthority> authorities) {
		super();
		this.id = id;
		this.password = password;
		this.username = username;
		this.authorities = authorities;
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
	public SecurityUserDetails(Collection<? extends GrantedAuthority> authorities, boolean accountNonExpired,
			boolean accountNonLocked, boolean credentialsNonExpired, boolean enabled, Long id, String password,
			String username) {
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

	@JsonIgnore
	@Override
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@JsonIgnore
	@Override
	public boolean isEnabled() {
		return enabled;
	}

	@JsonIgnore
	public Long getId() {
		return id;
	}

	@JsonIgnore
	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

}
