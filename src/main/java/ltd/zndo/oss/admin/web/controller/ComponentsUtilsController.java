package ltd.zndo.oss.admin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/components")
public class ComponentsUtilsController {
	
	@RequestMapping("/utils/idle-timer.html")
	public String idleTimer() {
		return "/components/utils/idle-timer";
	}
	
	@RequestMapping("/utils/session-timeout.html")
	public String sessionTimeout() {
		return "/components/utils/session-timeout";
	}

}
