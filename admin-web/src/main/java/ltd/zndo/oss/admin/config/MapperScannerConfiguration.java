package ltd.zndo.oss.admin.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

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
		"org.mybatis.springboot.mapper", // MyBatis
		"tk.mybatis.mapper.common", // TK Common Mapper
		"ltd.zndo.oss.admin.persistence.mapper" // Admin Mapper
})
@Configuration
public class MapperScannerConfiguration {

}
