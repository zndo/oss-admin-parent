package ltd.zndo.oss.admin.web.controller.rest;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ltd.zndo.oss.admin.web.security.entity.User;

@RestController
@PreAuthorize("hasRole('USER')")
@RequestMapping("/users")
public class UserRestController {

	@PreAuthorize("hasRole('USER')")
	@GetMapping
	public List<User> uesrs(){
		return null;
	}

}
