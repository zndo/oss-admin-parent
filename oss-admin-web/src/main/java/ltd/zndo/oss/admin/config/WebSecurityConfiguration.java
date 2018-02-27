package ltd.zndo.oss.admin.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import ltd.zndo.oss.admin.commons.util.PasswordUtil;
import ltd.zndo.oss.admin.web.security.filters.AdminUsernamePasswordAuthenticationFilter;
import ltd.zndo.oss.admin.web.security.handlers.SigninSuccessHandler;
import ltd.zndo.oss.admin.web.security.interceptors.URLFilterSecurityInterceptor;

import org.springframework.boot.autoconfigure.security.SecurityProperties;

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
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

//	private RequestCache requestCache = new HttpSessionRequestCache();

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

//	@Bean
//	public SigninSuccessHandler signinSuccessHandler() {
		
		// 获取登陆前来源页面
//		SavedRequest savedRequest = requestCache.getRequest(request, response);
//		String targetUrl = null;
//		if (savedRequest != null) {
//			targetUrl = savedRequest.getRedirectUrl();
//		}
//		Map<String, Object> result = new HashMap<String, Object>();
//		result.put("success", true);
//		result.put("targetUrl", targetUrl);
//		return result;
		
//		return new SigninSuccessHandler(); // 登录成功跳转默认登录成功页面
//		SigninSuccessHandler handler = new SigninSuccessHandler();
//		// 设置登陆前来源页面
//		
//		return handler;
//	}

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
						"/signin.html", // 登录页面
						"/signin", // 登录请求
						"/signin/success", // 登录成功
						"/signin/failure", // 登录失败
						"/logout") // 注销-signout
				.permitAll() // 匹配的 Matcher 内容全部允许
				// 允许无授权访问的资源匹配器
				.antMatchers(HttpMethod.POST, // 类型是 POST
						// 列表数据
						"/users", // 用户列表
						"/users2") // 用户列表2
				.permitAll() // 匹配的 Matcher 内容全部允许
				.anyRequest().authenticated() // 其他请求需要认证
				.and() // & 登录
				.formLogin() // 登录表单设置
					.loginPage("/signin.html") // 登录页面
					.loginProcessingUrl("/signin") // 自定义登录处理地址
		            .usernameParameter("username") // 自定义用户名参数
		            .passwordParameter("password") // 自定义密码参数
//					.successHandler(signinSuccessHandler()) // 登录成功处理器
					.defaultSuccessUrl("/signin/success") // 默认登录成功跳转地址
					.failureUrl("/signin/failure") // 登录失败跳转地址
				.and() // &
				.logout() // 注销
					.logoutUrl("/signout")//
					.logoutSuccessUrl("/signin.html")//
					.invalidateHttpSession(true) // 使 HTTPSession 失效
					.clearAuthentication(true) // 清除认证
				.and()//
				.rememberMe() // 记住我，需要预置表结构 persistent_logins
		// .tokenValiditySeconds(1209600) // TOKEN 有效期
		// .tokenRepository(tokenRepository());
		;

		// 禁用缓存
		security.headers().cacheControl();
		
		// 验证码过滤器
//		security.addFilterAt(aupAuthFilter(), UsernamePasswordAuthenticationFilter.class).exceptionHandling()
//        .authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/signin_page"));

		// 安全拦截器
//		security.addFilterBefore(adminFilterSecurityInterceptor, FilterSecurityInterceptor.class);
		
	}
	
	@Bean
	public AdminUsernamePasswordAuthenticationFilter aupAuthFilter()throws Exception {
		AdminUsernamePasswordAuthenticationFilter aupAuthFilter = new AdminUsernamePasswordAuthenticationFilter();
		aupAuthFilter.setAuthenticationManager(authenticationManagerBean());
//		aupAuthFilter.setAuthenticationSuccessHandler(authenticationSuccessHandler());
//		aupAuthFilter.setAuthenticationFailureHandler(authenticationFailureHandler());
//		aupAuthFilter.setRememberMeServices(tokenBasedRememberMeServices());
        return aupAuthFilter;
	}

//    @Bean
//    public AuthenticationSuccessHandler authenticationSuccessHandler() {
//        return new SimpleUrlAuthenticationSuccessHandler("/signin/success");
//    }
//
//    @Bean
//    public AuthenticationFailureHandler authenticationFailureHandler() {
//        return new SimpleUrlAuthenticationFailureHandler("/login/failure");
//    }

}
