package ltd.zndo.oss.admin.web.security;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class UserFactory {

	private UserFactory() {
	}

	// static User create(User user) {
	// return new User(
	// user.getId(),
	// user.getUsername(),
	// user.getPassword(),
	// //mapToGrantedAuthorities(user.getAuthorities().stream().map(Role::getName).collect(Collectors.toList()))
	// );
	// }

	// 将与用户类一对多的角色类的名称集合转换为 GrantedAuthority 集合
	private static List<GrantedAuthority> mapToGrantedAuthorities(List<String> authorities) {
		return authorities.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
	}
}
