package ltd.zndo.oss.admin.service.security.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.Assert;

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

	private String password; // 密码
	private String username; // 用户名
	private Collection<? extends GrantedAuthority> authorities; // 授予的权限
	private boolean accountNonExpired; // 帐号是否未过期
	private boolean accountNonLocked; // 帐号是否未锁定
	private boolean credentialsNonExpired; // 凭证是否未过期
	private boolean enabled; // 是否激活

	// 拓展属性
	private Long id; // ID
	private String email; // 邮箱地址
	private String phone; // 手机号

	// 用户的角色
	// @JsonIgnore
	// private Set<AdminRole> sysUsersRoles = new HashSet<AdminRole>(0);

	// Constructors

	/**
	 * 调用更复杂的构造函数，将所有布尔参数设置为 {@code true}。
	 */
	public SecurityUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		this(username, password, true, true, true, true, authorities);
	}

	/**
	 *
	 */
	public SecurityUserDetails(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {

		if ((StringUtils.isBlank(username)) || (password == null)) {
			throw new IllegalArgumentException("Cannot pass null or empty values to constructor");
		}

		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.accountNonExpired = accountNonExpired;
		this.credentialsNonExpired = credentialsNonExpired;
		this.accountNonLocked = accountNonLocked;
		this.authorities = Collections.unmodifiableSet(sortAuthorities(authorities));
	}

	/**
	 * 全参
	 * @param authorities
	 * @param password
	 * @param username
	 * @param accountNonExpired
	 * @param accountNonLocked
	 * @param credentialsNonExpired
	 * @param enabled
	 * @param id
	 * @param email
	 * @param phone
	 */
	public SecurityUserDetails(Collection<? extends GrantedAuthority> authorities, String password, String username,
			boolean accountNonExpired, boolean accountNonLocked, boolean credentialsNonExpired, boolean enabled,
			Long id, String email, String phone) {
		super();
		this.authorities = authorities;
		this.password = password;
		this.username = username;
		this.accountNonExpired = accountNonExpired;
		this.accountNonLocked = accountNonLocked;
		this.credentialsNonExpired = credentialsNonExpired;
		this.enabled = enabled;
		this.id = id;
		this.email = email;
		this.phone = phone;
	}

	// Getters & Setters

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	/**
	 * 擦除凭证
	 */
	public void eraseCredentials() {
		password = null;
	}

	private static SortedSet<GrantedAuthority> sortAuthorities(Collection<? extends GrantedAuthority> authorities) {
		Assert.notNull(authorities, "Cannot pass a null GrantedAuthority collection");
		// Ensure array iteration order is predictable (as per
		// UserDetails.getAuthorities() contract and SEC-717)
		SortedSet<GrantedAuthority> sortedAuthorities = new TreeSet<GrantedAuthority>(new AuthorityComparator());

		for (GrantedAuthority grantedAuthority : authorities) {
			Assert.notNull(grantedAuthority, "GrantedAuthority list cannot contain any null elements");
			sortedAuthorities.add(grantedAuthority);
		}

		return sortedAuthorities;
	}

	private static class AuthorityComparator implements Comparator<GrantedAuthority>, Serializable {
		private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

		public int compare(GrantedAuthority g1, GrantedAuthority g2) {
			// Neither should ever be null as each entry is checked before adding it to
			// the set.
			// If the authority is null, it is a custom authority and should precede
			// others.
			if (g2.getAuthority() == null) {
				return -1;
			}

			if (g1.getAuthority() == null) {
				return 1;
			}

			return g1.getAuthority().compareTo(g2.getAuthority());
		}
	}

}
