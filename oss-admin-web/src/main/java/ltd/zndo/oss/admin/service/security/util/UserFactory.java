package ltd.zndo.oss.admin.service.security.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.Assert;

public class UserFactory {

	private String username;
	private String password;
	private List<GrantedAuthority> authorities;
	private boolean accountExpired;
	private boolean accountLocked;
	private boolean credentialsExpired;
	private boolean disabled;

	/**
	 * Creates a new instance
	 */
	private UserFactory() {
	}

	/**
	 * Populates the username. This attribute is required.
	 *
	 * @param username the username. Cannot be null.
	 * @return the {@link UserFactory} for method chaining (i.e. to populate
	 * additional attributes for this user)
	 */
	private UserFactory username(String username) {
		Assert.notNull(username, "username cannot be null");
		this.username = username;
		return this;
	}

	/**
	 * Populates the password. This attribute is required.
	 *
	 * @param password the password. Cannot be null.
	 * @return the {@link UserFactory} for method chaining (i.e. to populate
	 * additional attributes for this user)
	 */
	public UserFactory password(String password) {
		Assert.notNull(password, "password cannot be null");
		this.password = password;
		return this;
	}

	/**
	 * Populates the roles. This method is a shortcut for calling
	 * {@link #authorities(String...)}, but automatically prefixes each entry with
	 * "ROLE_". This means the following:
	 *
	 * <code>
	 *     builder.roles("USER","ADMIN");
	 * </code>
	 *
	 * is equivalent to
	 *
	 * <code>
	 *     builder.authorities("ROLE_USER","ROLE_ADMIN");
	 * </code>
	 *
	 * <p>
	 * This attribute is required, but can also be populated with
	 * {@link #authorities(String...)}.
	 * </p>
	 *
	 * @param roles the roles for this user (i.e. USER, ADMIN, etc). Cannot be null,
	 * contain null values or start with "ROLE_"
	 * @return the {@link UserFactory} for method chaining (i.e. to populate
	 * additional attributes for this user)
	 */
	public UserFactory roles(String... roles) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>(
				roles.length);
		for (String role : roles) {
			Assert.isTrue(!role.startsWith("ROLE_"), role
					+ " cannot start with ROLE_ (it is automatically added)");
			authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
		}
		return authorities(authorities);
	}

	/**
	 * Populates the authorities. This attribute is required.
	 *
	 * @param authorities the authorities for this user. Cannot be null, or contain
	 * null values
	 * @return the {@link UserFactory} for method chaining (i.e. to populate
	 * additional attributes for this user)
	 * @see #roles(String...)
	 */
	public UserFactory authorities(GrantedAuthority... authorities) {
		return authorities(Arrays.asList(authorities));
	}

	/**
	 * Populates the authorities. This attribute is required.
	 *
	 * @param authorities the authorities for this user. Cannot be null, or contain
	 * null values
	 * @return the {@link UserFactory} for method chaining (i.e. to populate
	 * additional attributes for this user)
	 * @see #roles(String...)
	 */
	public UserFactory authorities(List<? extends GrantedAuthority> authorities) {
		this.authorities = new ArrayList<GrantedAuthority>(authorities);
		return this;
	}

	/**
	 * Populates the authorities. This attribute is required.
	 *
	 * @param authorities the authorities for this user (i.e. ROLE_USER, ROLE_ADMIN,
	 * etc). Cannot be null, or contain null values
	 * @return the {@link UserFactory} for method chaining (i.e. to populate
	 * additional attributes for this user)
	 * @see #roles(String...)
	 */
	public UserFactory authorities(String... authorities) {
		return authorities(AuthorityUtils.createAuthorityList(authorities));
	}

	/**
	 * Defines if the account is expired or not. Default is false.
	 *
	 * @param accountExpired true if the account is expired, false otherwise
	 * @return the {@link UserFactory} for method chaining (i.e. to populate
	 * additional attributes for this user)
	 */
	public UserFactory accountExpired(boolean accountExpired) {
		this.accountExpired = accountExpired;
		return this;
	}

	/**
	 * Defines if the account is locked or not. Default is false.
	 *
	 * @param accountLocked true if the account is locked, false otherwise
	 * @return the {@link UserFactory} for method chaining (i.e. to populate
	 * additional attributes for this user)
	 */
	public UserFactory accountLocked(boolean accountLocked) {
		this.accountLocked = accountLocked;
		return this;
	}

	/**
	 * Defines if the credentials are expired or not. Default is false.
	 *
	 * @param credentialsExpired true if the credentials are expired, false otherwise
	 * @return the {@link UserFactory} for method chaining (i.e. to populate
	 * additional attributes for this user)
	 */
	public UserFactory credentialsExpired(boolean credentialsExpired) {
		this.credentialsExpired = credentialsExpired;
		return this;
	}

	/**
	 * Defines if the account is disabled or not. Default is false.
	 *
	 * @param disabled true if the account is disabled, false otherwise
	 * @return the {@link UserFactory} for method chaining (i.e. to populate
	 * additional attributes for this user)
	 */
	public UserFactory disabled(boolean disabled) {
		this.disabled = disabled;
		return this;
	}

	public UserDetails build() {
		return new User(username, password, !disabled, !accountExpired,
				!credentialsExpired, !accountLocked, authorities);
	}
//
//	/**
//	 * 创建 自定义 UserDetails 对象
//	 * 
//	 * @param loadedUser
//	 * @param auths
//	 * @return
//	 */
//	public static SecurityUserDetails create(AdminUser loadedUser, List<AdminRole> adminRoles,
//			Collection<GrantedAuthority> auths) {
////		return new SecurityUserDetails( //
////				loadedUser.getId(), //
////				loadedUser.getPassword(), //
////				loadedUser.getUsername(), //
////				mapToGrantedAuthorities( //
////						adminRoles //
////								.stream() //
////								.map(AdminRole::getRoleName) //
////								.collect(Collectors.toList())) //
////		);
//		return null;
//	}
//
//	// 将与用户类一对多的角色类的名称集合转换为 GrantedAuthority 集合
//	private static List<GrantedAuthority> mapToGrantedAuthorities(List<String> authorities) {
//		return authorities//
//				.stream().map(SimpleGrantedAuthority::new)//
//				.collect(Collectors.toList() //
//		);
//	}

}
