package ltd.zndo.oss.admin.web.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ltd.zndo.oss.admin.persistence.entity.AdminUser;

@Controller
public class DashboardController {

	@GetMapping("/dashboard.html")
	public String dashboardPage(Model model) {

		// 获取登录用户
		SecurityContext ctx = SecurityContextHolder.getContext();
		Authentication auth = ctx.getAuthentication();
		if (auth.getPrincipal() instanceof UserDetails) {
			AdminUser user = (AdminUser) auth.getPrincipal();
			System.out.println("--------------> " + user.getEmail());
		}

		model.addAttribute("msg", "测试");

		return "index";
	}

}
