package ltd.zndo.oss.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ZndoMetronicAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZndoMetronicAdminApplication.class, args);
	}
}
