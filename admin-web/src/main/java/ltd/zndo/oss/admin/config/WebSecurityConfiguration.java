package ltd.zndo.oss.admin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.ManagementServerProperties.SessionCreationPolicy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Web 安全配置类
 * 
 * @author tianxin<tianxin@weconex.com>
 * @created 2018/01/01 9:00
 * @modified 2018/01/01 9:30
 * @since
 * @since JDK 1.8
 *
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	// Spring会自动寻找实现接口的类注入,会找到我们的 UserDetailsServiceImpl 类
	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	public void configureAuthentication(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder
				// 设置UserDetailsService
				.userDetailsService(this.userDetailsService)
				// 使用BCrypt进行密码的hash
				.passwordEncoder(passwordEncoder());
	}

	// 装载BCrypt密码编码器
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	// 允许跨域
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*")
						.allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS").allowCredentials(false)
						.maxAge(3600);
			}
		};
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
				// 取消csrf
				.csrf().disable()
				// 基于token，所以不需要session
				// .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
				.authorizeRequests() //
				.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
				// 允许对于网站静态资源的无授权访问
				.antMatchers(HttpMethod.GET, //
						"/", //
						"/*.html", //
						"/favicon.ico", //
						"/**/*.html", //
						"/**/*.css", //
						"/**/*.js", //
						"/static/**", //
						"/assets/**", //
						"/webjars/**", //
						"/swagger-resources/**", //
						"/*/api-docs")//
				.permitAll()
				// 对于获取token的rest api要允许匿名访问
				.antMatchers("/auth/**").permitAll()
				// 除上面外的所有请求全部需要鉴权认证
				.anyRequest().authenticated().and() //
				.formLogin() //
				.loginPage("/user/login") // 登录页面
				.failureUrl("/user/login?error") //
				.permitAll() //
				.and() //
				.logout().permitAll() //
				.and();
		// 禁用缓存
		httpSecurity.headers().cacheControl();
	}

}
