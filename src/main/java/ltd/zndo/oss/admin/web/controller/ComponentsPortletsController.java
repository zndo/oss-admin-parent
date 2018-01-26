package ltd.zndo.oss.admin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/components")
public class ComponentsPortletsController {
	
	@RequestMapping("/portlets/advanced.html")
	public String advanced() {
		return "/components/portlets/advanced";
	}
	
	@RequestMapping("/portlets/base.html")
	public String base() {
		return "/components/portlets/base";
	}
	
	@RequestMapping("/portlets/creative.html")
	public String creative() {
		return "/components/portlets/creative";
	}
	
	@RequestMapping("/portlets/draggable.html")
	public String draggable() {
		return "/components/portlets/draggable";
	}
	
	@RequestMapping("/portlets/tabbed.html")
	public String tabbed() {
		return "/components/portlets/tabbed";
	}
	
	@RequestMapping("/portlets/tools.html")
	public String tools() {
		return "/components/portlets/tools";
	}

}
