package ltd.zndo.oss.admin.web.security.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import ltd.zndo.oss.admin.web.security.entity.User;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		   // 这里是数据库里的用户类
//        User user = userRepository.findByAccount(account);
//
//        if (user == null) {
//            throw new UsernameNotFoundException(String.format("没有该用户 '%s'.", account));
//        } else {
//            //这里返回上面继承了 UserDetails  接口的用户类,为了简单我们写个工厂类
//            return UserFactory.create(user);
//        }
		return null;
	}

}
