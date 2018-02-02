package ltd.zndo.oss.admin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/components/base")
public class ComponentsBaseController {
	
	@RequestMapping("/tabs/bootstrap.html")
	public String bootstrap() {
		return "/components/base/tabs/bootstrap";
	}
	
	@RequestMapping("/tabs/line.html")
	public String line() {
		return "/components/base/tabs/line";
	}
	
	@RequestMapping("/accordions.html")
	public String accordions() {
		return "/components/base/accordions";
	}
	
	@RequestMapping("/alerts.html")
	public String alerts() {
		return "/components/base/alerts";
	}
	
	@RequestMapping("/blockui.html")
	public String blockui() {
		return "/components/base/blockui";
	}
	
	@RequestMapping("/bootstrap-notify.html")
	public String bootstrapNotify() {
		return "/components/base/bootstrap-notify";
	}
	
	@RequestMapping("/dropdown.html")
	public String dropdown() {
		return "/components/base/dropdown";
	}
	
	@RequestMapping("/lists.html")
	public String lists() {
		return "/components/base/lists";
	}
	
	@RequestMapping("/modal.html")
	public String modal() {
		return "/components/base/modal";
	}
	
	@RequestMapping("/navs.html")
	public String navs() {
		return "/components/base/navs";
	}
	
	@RequestMapping("/popover.html")
	public String popover() {
		return "/components/base/popover";
	}
	
	@RequestMapping("/progress.html")
	public String progress() {
		return "/components/base/progress";
	}
	
	@RequestMapping("/scrollable.html")
	public String scrollable() {
		return "/components/base/scrollable";
	}
	
	@RequestMapping("/spinners.html")
	public String spinners() {
		return "/components/base/spinners";
	}
	
	@RequestMapping("/stack.html")
	public String stack() {
		return "/components/base/stack";
	}
	
	@RequestMapping("/state.html")
	public String state() {
		return "/components/base/state";
	}
	
	@RequestMapping("/sweetalert2.html")
	public String sweetalert2() {
		return "/components/base/sweetalert2";
	}
	
	@RequestMapping("/tables.html")
	public String tables() {
		return "/components/base/tables";
	}
	
	@RequestMapping("/toastr.html")
	public String toastr() {
		return "/components/base/toastr";
	}
	
	@RequestMapping("/tooltip.html")
	public String tooltip() {
		return "/components/base/tooltip";
	}
	
	@RequestMapping("/treeview.html")
	public String treeview() {
		return "/components/base/treeview";
	}
	
	@RequestMapping("/typography.html")
	public String typography() {
		return "/components/base/typography";
	}

}
