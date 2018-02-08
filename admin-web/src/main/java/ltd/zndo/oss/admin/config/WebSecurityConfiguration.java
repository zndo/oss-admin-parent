package ltd.zndo.oss.admin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import ltd.zndo.oss.admin.commons.util.PasswordUtil;
import ltd.zndo.oss.admin.web.security.handlers.SigninSuccessHandler;
import ltd.zndo.oss.admin.web.security.interceptors.URLFilterSecurityInterceptor;

/**
 * Web 安全配置
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

	/**
	 * @see ltd.zndo.oss.admin.service.security.impl.UserDetailsServiceImpl
	 */
	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private URLFilterSecurityInterceptor adminFilterSecurityInterceptor;

	@Autowired
	public void configureAuthentication(AuthenticationManagerBuilder builder) throws Exception {
		builder
				// UserDetailsService
				.userDetailsService(this.userDetailsService)
				// 密码编码器
				.passwordEncoder(PasswordUtil.encoder);

		// 不擦除凭证
		builder.eraseCredentials(false);
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

	// @Bean
	// public JdbcTokenRepositoryImpl tokenRepository() {
	// setDataSource(ds);
	// return null;
	// }

	@Bean
	public SigninSuccessHandler signinSuccessHandler() {
		return new SigninSuccessHandler();
	}

	@Override
	protected void configure(HttpSecurity security) throws Exception {
		security
				// 取消 CSRF
				.csrf().disable()
				// 请求认证
				.authorizeRequests()
				// OPTIONS
				.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
				// 允许无授权访问的资源匹配器
				.antMatchers(HttpMethod.GET, // 类型是 GET
						// 静态资源
						"/favicon.ico", // 站点图标
						"/static/**", //
						"/assets/**", //
						// Swagger 资源
						"/webjars/**", //
						"/swagger-resources/**", //
						"/*/api-docs", //
						// 页面
						"/sigin", // 登录
						"/logout") // 注销-signout
				.permitAll()
				// 其他请求需要认证
				.anyRequest().authenticated()//
				.and() //
				.formLogin() //
				.loginPage("/signin") // 登录页面
				.defaultSuccessUrl("/") // 登录成功跳转地址
				.failureUrl("/signin?failure") //
				.successHandler(signinSuccessHandler()) //
				.and() //
				.logout()//
				.logoutSuccessUrl("/user/login")//
				.invalidateHttpSession(true) // 使 HTTPSession 失效
				.clearAuthentication(true) // 清除认证
				.and()//
				.rememberMe() // 记住我，需要预置表结构 persistent_logins
		// .tokenValiditySeconds(1209600) // TOKEN 有效期
		// .tokenRepository(tokenRepository());
		;

		// 禁用缓存
		security.headers().cacheControl();

		// 安全拦截器
		security.addFilterBefore(adminFilterSecurityInterceptor, FilterSecurityInterceptor.class);

	}

}
