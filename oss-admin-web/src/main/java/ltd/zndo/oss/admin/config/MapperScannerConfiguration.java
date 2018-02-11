package ltd.zndo.oss.admin.config;

import java.util.Properties;

import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Configuration;

import tk.mybatis.spring.annotation.MapperScan;

/**
 * MyBatis Mapper 接口扫描器配置
 * 
 * @author tianxin<tianxin@weconex.com>
 * @created 2018/01/01 9:00
 * @modified 2018/01/01 9:30
 * @since
 * @since JDK 1.8
 *
 */
@MapperScan(basePackages = { // 基础包
//		"org.mybatis.springboot.mapper", // MyBatis
//		"tk.mybatis.mapper.common", // TK Common Mapper
		"ltd.zndo.oss.admin.persistence.mapper" // Admin Mapper
})
@Configuration
@AutoConfigureAfter(MybatisAutoConfiguration.class)
public class MapperScannerConfiguration {

//    @Bean
//    public MapperScannerConfigurer mapperScannerConfigurer() {
//        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
//        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
//        mapperScannerConfigurer.setBasePackage("org.springboot.sample.mapper");
//        Properties properties = new Properties();
//        properties.setProperty("mappers", BaseMapper.class.getName());
//        properties.setProperty("notEmpty", "false");
//        properties.setProperty("IDENTITY", "MYSQL");
//        mapperScannerConfigurer.setProperties(properties);
//        return mapperScannerConfigurer;
//    }
    
}
