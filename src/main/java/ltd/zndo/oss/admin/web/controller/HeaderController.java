package ltd.zndo.oss.admin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/header")
public class HeaderController {
	
	@RequestMapping("/actions.html")
	public String actions() {
		return "/header/actions";
	}
	
	@RequestMapping("/profile.html")
	public String profile() {
		return "/header/profile";
	}

}
