package ltd.zndo.oss.admin.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@MapperScan(basePackages = { "ltd.zndo.oss.admin.persistence.mapper" }) // "org.mybatis.springboot.mapper",
@Configuration
public class MybatisConfiguration {

}
