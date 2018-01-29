package ltd.zndo.oss.admin.web.controller.rest;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ltd.zndo.oss.admin.web.security.entity.User;

@RestController
@RequestMapping("/users")
@PreAuthorize("hasRole('ADMIN')")
public class UserRestController {
	
	@GetMapping
	public List<User> uesrs(){
		return null;
	}

}
