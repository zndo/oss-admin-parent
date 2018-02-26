package ltd.zndo.oss.admin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

	/**
	 * 用户列表页面
	 * 
	 * @return
	 */
	@GetMapping("/users.html")
	public String usersPage() {
		return "/admin/user/users";
	}

}
