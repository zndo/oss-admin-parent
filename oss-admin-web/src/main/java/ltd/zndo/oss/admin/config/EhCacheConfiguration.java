package ltd.zndo.oss.admin.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.cache.interceptor.CacheResolver;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.interceptor.SimpleKeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

//@Configuration
public class EhCacheConfiguration {//implements CachingConfigurer {

//	/**
//	 * ehcache 主要的管理器
//	 */
//	@Bean(name = "ehCacheCacheManager")
//	public EhCacheCacheManager ehCacheCacheManager(EhCacheManagerFactoryBean bean) {
//		return new EhCacheCacheManager(bean.getObject());
//	}
//
//	/**
//	 * 据shared与否的设置,Spring分别通过CacheManager.create()或new
//	 * CacheManager()方式来创建一个ehcache基地.
//	 */
//	@Bean
//	public EhCacheManagerFactoryBean ehCacheManagerFactoryBean() {
//		EhCacheManagerFactoryBean cacheManagerFactoryBean = new EhCacheManagerFactoryBean();
//		cacheManagerFactoryBean.setConfigLocation(new ClassPathResource("config/ehcache.xml"));
//		cacheManagerFactoryBean.setShared(true);
//		return cacheManagerFactoryBean;
//	}
//
//	@Override
//	public CacheManager cacheManager() {
//		return ehCacheCacheManager(ehCacheManagerFactoryBean());
//	}
//
//	@Override
//	public CacheResolver cacheResolver() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public KeyGenerator keyGenerator() {
//		return new SimpleKeyGenerator();
//	}
//
//	@Override
//	public CacheErrorHandler errorHandler() {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
