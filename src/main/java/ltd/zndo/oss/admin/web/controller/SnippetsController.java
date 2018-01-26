package ltd.zndo.oss.admin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/snippets")
public class SnippetsController {

	@RequestMapping("/faq/faq-1.html")
	public String faq1() {
		return "/snippets/faq/faq-1";
	}

	@RequestMapping("/general/pricing-tables/pricing-table-1.html")
	public String pricingTable1() {
		return "/snippets/general/pricing-tables/pricing-table-1";
	}

	@RequestMapping("/general/pricing-tables/pricing-table-2.html")
	public String pricingTable2() {
		return "/snippets/general/pricing-tables/pricing-table-2";
	}

	@RequestMapping("/general/pricing-tables/pricing-table-3.html")
	public String pricingTable3() {
		return "/snippets/general/pricing-tables/pricing-table-3";
	}

	@RequestMapping("/general/pricing-tables/pricing-table-4.html")
	public String pricingTable4() {
		return "/snippets/general/pricing-tables/pricing-table-4";
	}

	@RequestMapping("/pages/errors/error-1.html")
	public String error1() {
		return "/snippets/pages/errors/error-1";
	}

	@RequestMapping("/pages/errors/error-2.html")
	public String error2() {
		return "/snippets/pages/errors/error-2";
	}

	@RequestMapping("/pages/errors/error-3.html")
	public String error3() {
		return "/snippets/pages/errors/error-3";
	}

	@RequestMapping("/pages/errors/error-4.html")
	public String error4() {
		return "/snippets/pages/errors/error-4";
	}

	@RequestMapping("/pages/errors/error-5.html")
	public String error5() {
		return "/snippets/pages/errors/error-5";
	}

	@RequestMapping("/pages/errors/error-6.html")
	public String error6() {
		return "/snippets/pages/errors/error-6";
	}

	@RequestMapping("/pages/user/login-1.html")
	public String login1() {
		return "/snippets/pages/user/login-1";
	}

	@RequestMapping("/pages/user/login-2.html")
	public String login2() {
		return "/snippets/pages/user/login-2";
	}

	@RequestMapping("/pages/user/login-3.html")
	public String login3() {
		return "/snippets/pages/user/login-3";
	}

	@RequestMapping("/pages/user/login-4.html")
	public String login4() {
		return "/snippets/pages/user/login-4";
	}

	@RequestMapping("/pages/user/login-5.html")
	public String login5() {
		return "/snippets/pages/user/login-5";
	}

}
