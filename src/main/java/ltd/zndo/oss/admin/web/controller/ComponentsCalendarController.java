package ltd.zndo.oss.admin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/components/calendar")
public class ComponentsCalendarController {
	
	@RequestMapping("/background-events.html")
	public String backgroundEvents() {
		return "/components/calendar/background-events";
	}
	
	@RequestMapping("/basic.html")
	public String basic() {
		return "/components/calendar/basic";
	}
	
	@RequestMapping("/external-events.html")
	public String externalEvents() {
		return "/components/calendar/external-events";
	}
	
	@RequestMapping("/google.html")
	public String google() {
		return "/components/calendar/google";
	}
	
	@RequestMapping("/list-view.html")
	public String listView() {
		return "/components/calendar/list-view";
	}

}
