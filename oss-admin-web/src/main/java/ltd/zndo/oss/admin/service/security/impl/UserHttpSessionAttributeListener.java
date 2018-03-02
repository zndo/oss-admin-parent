package ltd.zndo.oss.admin.service.security.impl;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import ltd.zndo.oss.admin.service.security.entity.SecurityUserDetails;

/**
 * 用户信息监听器
 * @author admin
 *
 */
public class UserHttpSessionAttributeListener implements HttpSessionAttributeListener {

	protected final Log logger = LogFactory.getLog(getClass());
	
	private SecurityContext context = null;

    private final String springSecurityContext = "SPRING_SECURITY_CONTEXT";

    
	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		// 当前session中有新的属性时触发 SPRING_SECURITY_CONTEXT 是spring存放的key

        if (event.getName().equals(springSecurityContext)) {

            context = SecurityContextHolder.getContext();

            SecurityUserDetails account = (SecurityUserDetails) context.getAuthentication().getPrincipal();

//            event.getSession().setAttribute(ConfigUtil.getSessionInfoName(), account);

        }

	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		  if (event.getName().equals(springSecurityContext)) {

	            // System.out.println("----session中更新登陆信息------");

	            context = SecurityContextHolder.getContext();

	            SecurityUserDetails account = (SecurityUserDetails) context.getAuthentication().getPrincipal();

//	            event.getSession().setAttribute(ConfigUtil.getSessionInfoName(), account);

	        }

	}

}
