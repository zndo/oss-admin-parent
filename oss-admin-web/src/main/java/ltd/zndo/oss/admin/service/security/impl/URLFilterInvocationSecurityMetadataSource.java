package ltd.zndo.oss.admin.service.security.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Service;

import ltd.zndo.oss.admin.persistence.mapper.AdminResourceMapper;

/**
 * 
 * 实现 FilterInvocationSecurityMetadataSource 接口
 * 
 * @see Open Declaration
 *      org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource
 * @author admin
 *
 */
@Service
public class URLFilterInvocationSecurityMetadataSource
		implements FilterInvocationSecurityMetadataSource, InitializingBean {

	protected final Log logger = LogFactory.getLog(getClass());

	private final static List<ConfigAttribute> NULL_CONFIG_ATTRIBUTE = Collections.emptyList();

	// 权限集合
	private Map<RequestMatcher, Collection<ConfigAttribute>> requestMap;

	@Autowired
	private AdminResourceMapper adminResourceMapper;

	/**
	 * 获取属性
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.security.access.SecurityMetadataSource#getAttributes(java
	 * .lang.Object)
	 */
	@Override
	public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {

		logger.info("资源类型：" + object.getClass());

		FilterInvocation filterInvocation = (FilterInvocation) object;
		final HttpServletRequest request = filterInvocation.getRequest();

		String requestURL = filterInvocation.getRequestUrl();
		logger.info("请求地址：" + requestURL);

		String servletPath = filterInvocation.getRequest().getServletPath();
		logger.info("请求路径：" + servletPath);

		// Url urlObject = getRoleByUrl(url); //调用自己实现的方法来url
		// System.out.println("urlObject:" + urlObject);
		// if (urlObject != null && urlObject.getPrivilege() != null) {
		// Set<Role> roles = urlObject.getPrivilege().getRoles();
		// Collection<ConfigAttribute> c = new HashSet<ConfigAttribute>();
		// c.addAll(roles);
		// return c; //
		// 将privilege中的roles改为Collection<ConfigAttribute>，role需要实现ConfigAttribute接口
		// } else {
		// // 如果返回为null则说明此url地址不需要相应的角色就可以访问, 这样Security会放行
		// return null;
		// }

		// if(map ==null) loadResourceDefine();
		// //object 中包含用户请求的request 信息
		// HttpServletRequest request = ((FilterInvocation) object).getHttpRequest();
		// AntPathRequestMatcher matcher;
		// String resUrl;
		// for(Iterator<String> iter = map.keySet().iterator(); iter.hasNext(); ) {
		// resUrl = iter.next();
		// matcher = new AntPathRequestMatcher(resUrl);
		// if(matcher.matches(request)) {
		// return map.get(resUrl);
		// }
		// }

		Collection<ConfigAttribute> attrs = NULL_CONFIG_ATTRIBUTE;

		for (Map.Entry<RequestMatcher, Collection<ConfigAttribute>> entry : requestMap.entrySet()) {
			if (entry.getKey().matches(request)) {
				attrs = entry.getValue();
				break;
			}
		}
		logger.info("URL资源：" + request.getRequestURI() + " -> " + attrs);
		return attrs;
	}

	/**
	 * 获取所有配置属性
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.access.SecurityMetadataSource#
	 * getAllConfigAttributes()
	 */
	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		Set<ConfigAttribute> allAttributes = new HashSet<ConfigAttribute>();

		for (Map.Entry<RequestMatcher, Collection<ConfigAttribute>> entry : requestMap.entrySet()) {
			allAttributes.addAll(entry.getValue());
		}

		return allAttributes;
	}

	/**
	 * 判断是否支持当前格式类型，如果支持则可以通过 getAttributes 方法获取属性
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.security.access.SecurityMetadataSource#supports(java.lang
	 * .Class)
	 */
	@Override
	public boolean supports(Class<?> clazz) {
		// 判断两个类或接口是否相同，或存在继承关系
		return FilterInvocation.class.isAssignableFrom(clazz);
	}

	/**
	 * 加载资源
	 * 
	 * @return
	 */
	private Map<String, String> loadResuorce() {
		Map<String, String> map = new LinkedHashMap<String, String>();

		List<Map<String, String>> list = this.adminResourceMapper.loadResourcesMapping();
		Iterator<Map<String, String>> it = list.iterator();
		while (it.hasNext()) {
			Map<String, String> rs = it.next();
			String resourcePath = rs.get("URL");
			String authority = rs.get("AUTHORITY");

			if (map.containsKey(resourcePath)) {
				String mark = map.get("URL");
				map.put(resourcePath, mark + "," + authority);
			} else {
				map.put(resourcePath, authority);
			}
		}

		// array = new ArrayList<>();
		// cfg = new SecurityConfig(permission.getName());
		// //此处只添加了用户的名字，其实还可以添加更多权限的信息，例如请求方法到ConfigAttribute的集合中去。此处添加的信息将会作为MyAccessDecisionManager类的decide的第三个参数。
		// array.add(cfg);
		// //用权限的getUrl() 作为map的key，用ConfigAttribute的集合作为 value，
		// map.put(permission.getUrl(), array);

		return map;
	}

	/**
	 * 
	 * @return
	 */
	protected Map<RequestMatcher, Collection<ConfigAttribute>> bindRequestMap() {
		Map<RequestMatcher, Collection<ConfigAttribute>> map = new LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>>();

		Map<String, String> resMap = this.loadResuorce();
		for (Map.Entry<String, String> entry : resMap.entrySet()) {
			String key = entry.getKey();
			Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();
			atts = SecurityConfig.createListFromCommaDelimitedString(entry.getValue());
			map.put(new AntPathRequestMatcher(key), atts);
		}

		return map;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		this.requestMap = this.bindRequestMap();
		logger.info("资源权限列表" + this.requestMap);
	}

	public void refreshResuorceMap() {
		this.requestMap = this.bindRequestMap();
	}
	/**
	 * 加载权限表中所有权限
	 */
	// public void loadResourceDefine(){
	// map = new HashMap<>();
	// Collection<ConfigAttribute> array;
	// ConfigAttribute cfg;
	// List<Permission> permissions = permissionDao.findAll();
	// for(Permission permission : permissions) {
	// array = new ArrayList<>();
	// cfg = new SecurityConfig(permission.getName());
	// //此处只添加了用户的名字，其实还可以添加更多权限的信息，例如请求方法到ConfigAttribute的集合中去。此处添加的信息将会作为MyAccessDecisionManager类的decide的第三个参数。
	// array.add(cfg);
	// //用权限的getUrl() 作为map的key，用ConfigAttribute的集合作为 value，
	// map.put(permission.getUrl(), array);
	// }
	//
	// }
	//
	//// 此方法是为了判定用户请求的url 是否在权限表中，如果在权限表中，则返回给 decide 方法，用来判定用户是否有此权限。如果不在权限表中则放行。
	// @Override
	// public Collection<ConfigAttribute> getAttributes(Object object) throws
	// IllegalArgumentException {
	// if(map ==null) loadResourceDefine();
	// //object 中包含用户请求的request 信息
	// HttpServletRequest request = ((FilterInvocation) object).getHttpRequest();
	// AntPathRequestMatcher matcher;
	// String resUrl;
	// for(Iterator<String> iter = map.keySet().iterator(); iter.hasNext(); ) {
	// resUrl = iter.next();
	// matcher = new AntPathRequestMatcher(resUrl);
	// if(matcher.matches(request)) {
	// return map.get(resUrl);
	// }
	// }
	// return null;
	// }

}
