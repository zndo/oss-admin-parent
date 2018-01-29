package ltd.zndo.oss.admin.web.controller.rest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexRestController {
	
	@PostMapping("/signin")
	public String sigin(){
		return "";
	}

}
