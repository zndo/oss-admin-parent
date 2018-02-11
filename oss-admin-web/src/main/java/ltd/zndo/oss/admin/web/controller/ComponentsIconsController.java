package ltd.zndo.oss.admin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/components")
public class ComponentsIconsController {
	
	@RequestMapping("/icons/flaticon.html")
	public String flaticon() {
		return "/components/icons/flaticon";
	}
	
	@RequestMapping("/icons/fontawesome.html")
	public String fontawesome() {
		return "/components/icons/fontawesome";
	}
	
	@RequestMapping("/icons/lineawesome.html")
	public String lineawesome() {
		return "/components/icons/lineawesome";
	}
	
	@RequestMapping("/icons/socicons.html")
	public String socicons() {
		return "/components/icons/socicons";
	}

}
