package ltd.zndo.oss.admin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/components")
public class ComponentsTimelineController {
	
	@RequestMapping("/timeline/timeline-1.html")
	public String timeline1() {
		return "/components/timeline/timeline-1";
	}
	
	@RequestMapping("/timeline/timeline-2.html")
	public String timeline2() {
		return "/components/timeline/timeline-2";
	}
	
}
