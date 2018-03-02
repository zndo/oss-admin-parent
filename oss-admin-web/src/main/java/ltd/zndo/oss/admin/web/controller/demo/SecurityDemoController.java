package ltd.zndo.oss.admin.web.controller.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityDemoController {

	/**
	 * 权限演示
	 * 
	 * @return
	 */
	@GetMapping("/security-demo.html")
	public String usersPage() {
		return "/security-demo";
	}

}
