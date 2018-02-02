package ltd.zndo.oss.admin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/components/buttons")
public class ComponentsButtonsController {
	
	@RequestMapping("/base/air.html")
	public String air() {
		return "/components/buttons/base/air";
	}
	
	@RequestMapping("/base/default.html")
	public String defaultP() {
		return "/components/buttons/base/default";
	}
	
	@RequestMapping("/base/pill.html")
	public String pill() {
		return "/components/buttons/base/pill";
	}
	
	@RequestMapping("/base/square.html")
	public String square() {
		return "/components/buttons/base/square";
	}
	
	@RequestMapping("/icon/flaticon.html")
	public String flaticon() {
		return "/components/buttons/icon/flaticon";
	}
	
	@RequestMapping("/icon/fontawesome.html")
	public String fontawesome() {
		return "/components/buttons/icon/fontawesome";
	}
	
	@RequestMapping("/icon/lineawesome.html")
	public String lineawesome() {
		return "/components/buttons/icon/lineawesome";
	}
	
	@RequestMapping("/dropdown.html")
	public String dropdown() {
		return "/components/buttons/dropdown";
	}
	
	@RequestMapping("/group.html")
	public String group() {
		return "/components/buttons/group";
	}
	
	@RequestMapping("/spinner.html")
	public String spinner() {
		return "/components/buttons/spinner";
	}

}
