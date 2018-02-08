package ltd.zndo.oss.admin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	
	@RequestMapping("/signin")
	public String index() {
		return "/user/signin";
	}

}
