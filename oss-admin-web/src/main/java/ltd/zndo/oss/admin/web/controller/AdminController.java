package ltd.zndo.oss.admin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

	/**
	 * 登录页面
	 * 
	 * @return
	 */
	@GetMapping("/signin.html")
	public String signinPage() {
		return "/admin/signin";
	}

}
