package ltd.zndo.oss.admin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/components")
public class ComponentsMapsController {
	
	@RequestMapping("/maps/google-maps.html")
	public String googleMaps() {
		return "/components/maps/google-maps";
	}
	
	@RequestMapping("/maps/jqvmap.html")
	public String line() {
		return "/components/maps/jqvmap";
	}

}
