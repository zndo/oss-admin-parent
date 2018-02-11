package ltd.zndo.oss.admin.web.controller.rest.demo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/demo")
public class SwaggerDemoRestController {

	@ApiOperation(value = "接口名称", notes = "接口描述")
	@GetMapping("/swagger2")
	public String swagger(@RequestBody @ApiParam(value = "", required = true) Object obj, HttpServletRequest request){
		return null;
	}

}
