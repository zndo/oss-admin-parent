package ltd.zndo.oss.admin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Web MVC 配置类
 * 
 * @author tianxin<tianxin@weconex.com>
 * @created 2017/1/1 9:00
 * @modified 2017/1/1 9:30
 * @since
 * @since JDK 1.8
 *
 */
@Configuration
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {

	/**
	 * 因 Swagger-UI 的资源位于 /webjars 目录，自定义映射让应用能访问<br>
	 * 等价于<br>
	 * &lt;mvc:resources location="classpath:/META-INF/resources/" mapping=
	 * "swagger-ui.html"&gt; <br>
	 * &lt;mvc:resources location="classpath:/META-INF/resources/webjars/" mapping=
	 * "/webjars/**"&gt;
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		super.addResourceHandlers(registry);

		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");

		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
		
//		registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");

		registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/static/assets/");

		// registry.addResourceHandler("/json/**")
		// .addResourceLocations("classpath:/static/json/");
	}

}
