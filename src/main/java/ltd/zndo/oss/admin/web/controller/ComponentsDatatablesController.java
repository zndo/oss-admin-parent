package ltd.zndo.oss.admin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/components/datatables")
public class ComponentsDatatablesController {
	
	@RequestMapping("/api/events.html")
	public String events() {
		return "/components/datatables/api/events";
	}
	
	@RequestMapping("/api/methods.html")
	public String methods() {
		return "/components/datatables/api/methods";
	}
	
	@RequestMapping("/base/auto-column-hide.html")
	public String autoColumnHide() {
		return "/components/datatables/base/auto-column-hide";
	}
	
	@RequestMapping("/base/column-rendering.html")
	public String columnRendering() {
		return "/components/datatables/base/column-rendering";
	}
	
	@RequestMapping("/base/column-width.html")
	public String columnWidth() {
		return "/components/datatables/base/column-width";
	}
	
	@RequestMapping("/base/data-ajax.html")
	public String dataAjax() {
		return "/components/datatables/base/data-ajax";
	}
	
	@RequestMapping("/base/data-json.html")
	public String dataJson() {
		return "/components/datatables/base/data-json";
	}
	
	@RequestMapping("/base/data-local.html")
	public String dataLocal() {
		return "/components/datatables/base/data-local";
	}
	
	@RequestMapping("/base/html-table.html")
	public String htmlTable() {
		return "/components/datatables/base/html-table";
	}
	
	@RequestMapping("/base/local-sort.html")
	public String localSort() {
		return "/components/datatables/base/local-sort";
	}
	
	@RequestMapping("/base/record-selection.html")
	public String recordSelection() {
		return "/components/datatables/base/record-selection";
	}
	
	@RequestMapping("/base/responsive-columns.html")
	public String responsiveColumns() {
		return "/components/datatables/base/responsive-columns";
	}
	
	@RequestMapping("/base/row-details.html")
	public String rowDetails() {
		return "/components/datatables/base/row-details";
	}
	
	@RequestMapping("/base/translation.html")
	public String translation() {
		return "/components/datatables/base/translation";
	}
	
	@RequestMapping("/child/data-ajax.html")
	public String childDataAjax() {
		return "/components/datatables/child/data-ajax";
	}
	
	@RequestMapping("/child/data-local.html")
	public String childDataLocal() {
		return "/components/datatables/child/data-local";
	}
	
	@RequestMapping("/locked/both.html")
	public String both() {
		return "/components/datatables/locked/both";
	}
	
	@RequestMapping("/locked/html-table.html")
	public String lockedHtmlTable() {
		return "/components/datatables/locked/html-table";
	}
	
	@RequestMapping("/locked/left.html")
	public String left() {
		return "/components/datatables/locked/left";
	}
	
	@RequestMapping("/locked/right.html")
	public String right() {
		return "/components/datatables/locked/right";
	}
	
	@RequestMapping("/scrolling/both.html")
	public String scrollingBoth() {
		return "/components/datatables/scrolling/both";
	}
	
	@RequestMapping("/scrolling/horizontal.html")
	public String scrollingHorizontal() {
		return "/components/datatables/scrolling/horizontal";
	}
	
	@RequestMapping("/scrolling/vertical.html")
	public String scrollingVertical() {
		return "/components/datatables/scrolling/vertical";
	}
	
}
