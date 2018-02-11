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
	private Collection<? extends GrantedAuthority> authorities;// final

	private boolean credentialsNonExpired;

	// 邮箱
	private String email;

	private boolean enabled;

	// ID
	private Long id; // final

	// 密码
	private String password;// final

	// 手机号
	private String phone;

	// 用户名
	private String username;// final

	// 用户的角色
	// @JsonIgnore
	// private Set<AdminRole> sysUsersRoles = new HashSet<AdminRole>(0);

	// Constructors

	// /**
	// * 构造方法-半参
	// *
	// * @param id
	// * @param username
	// * @param password
	// * @param authorities
	// */
	// public SecurityUserDetails(Collection<? extends GrantedAuthority>
	// authorities, String id, String password,
	// String username) {
	// super();
	// this.authorities = authorities;
	// this.id = id;
	// this.password = password;
	// this.username = username;
	// }

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * 构造方法-半参
	 * 
	 * @param id
	 * @param password
	 * @param username
	 * @param authorities
	 */
	public SecurityUserDetails(Collection<? extends GrantedAuthority> authorities, String email, Long id, String password,
			String phone,
			String username) {
		super();
		this.authorities = authorities;
		this.email = email;
		this.id = id;
		this.password = password;
		this.phone = phone;
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
	public SecurityUserDetails(boolean accountNonExpired,
			boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities, boolean credentialsNonExpired, String email, boolean enabled, Long id, String password,
			String phone,
			String username) {
		super();
		this.accountNonExpired = accountNonExpired;
		this.accountNonLocked = accountNonLocked;
		this.authorities = authorities;
		this.credentialsNonExpired = credentialsNonExpired;
		this.email = email;
		this.enabled = enabled;
		this.id = id;
		this.password = password;
		this.phone = phone;
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

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

}
