package next.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import core.jdbc.ConnectionManager;

@Configuration
@ComponentScan(basePackages = { "next.service", "next.dao", "next.support.context" })
public class AppConfig {
	
}
