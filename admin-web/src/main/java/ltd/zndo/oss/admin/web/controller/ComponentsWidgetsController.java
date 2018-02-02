package ltd.zndo.oss.admin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/components")
public class ComponentsWidgetsController {
	
	@RequestMapping("/widgets/chart.html")
	public String chart() {
		return "/components/widgets/chart";
	}
	
	@RequestMapping("/widgets/general.html")
	public String general() {
		return "/components/widgets/general";
	}

}
