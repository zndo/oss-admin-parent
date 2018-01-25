package ltd.zndo.oss.admin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/components")
public class ComponentsTimelineController {
	
	@RequestMapping("/base/tabs/bootstrap.html")
	public String bootstrap() {
		return "/components/base/tabs/bootstrap";
	}
	
	@RequestMapping("/base/tabs/line.html")
	public String line() {
		return "/components/base/tabs/line";
	}
	
	@RequestMapping("/base/accordions.html")
	public String accordions() {
		return "/components/base/accordions";
	}
	
	@RequestMapping("/base/alerts.html")
	public String alerts() {
		return "/components/base/alerts";
	}
	
	@RequestMapping("/base/blockui.html")
	public String blockui() {
		return "/components/base/blockui";
	}
	
	@RequestMapping("/base/bootstrap-notify.html")
	public String bootstrapNotify() {
		return "/components/base/bootstrap-notify";
	}
	
	@RequestMapping("/base/dropdown.html")
	public String dropdown() {
		return "/components/base/dropdown";
	}
	
	@RequestMapping("/base/lists.html")
	public String lists() {
		return "/components/base/lists";
	}
	
	@RequestMapping("/base/modal.html")
	public String modal() {
		return "/components/base/modal";
	}
	
	@RequestMapping("/base/navs.html")
	public String navs() {
		return "/components/base/navs";
	}
	
	@RequestMapping("/base/popover.html")
	public String popover() {
		return "/components/base/popover";
	}
	
	@RequestMapping("/base/progress.html")
	public String progress() {
		return "/components/base/progress";
	}
	
	@RequestMapping("/base/scrollable.html")
	public String scrollable() {
		return "/components/base/scrollable";
	}
	
	@RequestMapping("/base/spinners.html")
	public String spinners() {
		return "/components/base/spinners";
	}
	
	@RequestMapping("/base/stack.html")
	public String stack() {
		return "/components/base/stack";
	}
	
	@RequestMapping("/base/state.html")
	public String state() {
		return "/components/base/state";
	}
	
	@RequestMapping("/base/sweetalert2.html")
	public String sweetalert2() {
		return "/components/base/sweetalert2";
	}
	
	@RequestMapping("/base/tables.html")
	public String tables() {
		return "/components/base/tables";
	}
	
	@RequestMapping("/base/toastr.html")
	public String toastr() {
		return "/components/base/toastr";
	}
	
	@RequestMapping("/base/tooltip.html")
	public String tooltip() {
		return "/components/base/tooltip";
	}
	
	@RequestMapping("/base/treeview.html")
	public String treeview() {
		return "/components/base/treeview";
	}
	
	@RequestMapping("/base/typography.html")
	public String typography() {
		return "/components/base/typography";
	}

}
