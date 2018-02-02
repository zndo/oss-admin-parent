package ltd.zndo.oss.admin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/components/charts")
public class ComponentsChartsController {
	
	@RequestMapping("/amcharts/charts.html")
	public String charts() {
		return "/components/charts/amcharts/charts";
	}
	
	@RequestMapping("/amcharts/maps.html")
	public String maps() {
		return "/components/charts/amcharts/maps";
	}
	
	@RequestMapping("/amcharts/stock-charts.html")
	public String stockCharts() {
		return "/components/charts/amcharts/stock-charts";
	}
	
	@RequestMapping("/flotcharts.html")
	public String flotcharts() {
		return "/components/charts/flotcharts";
	}
	
	@RequestMapping("/google-charts.html")
	public String googleCharts() {
		return "/components/charts/google-charts";
	}
	
	@RequestMapping("/morris-charts.html")
	public String morrisCharts() {
		return "/components/charts/morris-charts";
	}

}
