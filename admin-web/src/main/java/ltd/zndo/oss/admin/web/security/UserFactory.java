package ltd.zndo.oss.admin.web.security;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import ltd.zndo.oss.admin.persistence.entity.AdminRole;
import ltd.zndo.oss.admin.persistence.entity.AdminUser;
import ltd.zndo.oss.admin.web.security.entity.SecurityUserDetails;

public class UserFactory {

	private UserFactory() {
	}

	/**
	 * 创建 自定义 UserDetails 对象
	 * 
	 * @param loadedUser
	 * @param auths
	 * @return
	 */
	public static SecurityUserDetails create(AdminUser loadedUser, List<AdminRole> adminRoles,
			Collection<GrantedAuthority> auths) {
		return new SecurityUserDetails( //
				loadedUser.getId(), //
				loadedUser.getPassword(), //
				loadedUser.getUsername(), //
				mapToGrantedAuthorities( //
						adminRoles //
								.stream() //
								.map(AdminRole::getRoleName) //
								.collect(Collectors.toList())) //
		);
	}

	// 将与用户类一对多的角色类的名称集合转换为 GrantedAuthority 集合
	private static List<GrantedAuthority> mapToGrantedAuthorities(List<String> authorities) {
		return authorities//
				.stream().map(SimpleGrantedAuthority::new)//
				.collect(Collectors.toList() //
		);
	}

}
