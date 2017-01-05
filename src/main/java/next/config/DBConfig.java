package next.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import core.jdbc.ConnectionManager;
import org.apache.commons.dbcp2.BasicDataSource;

@Configuration
@ComponentScan(basePackages = { "core.jdbc" })
public class DBConfig {	
	private static final String DB_DRIVER = "org.h2.Driver";
	private static final String DB_URL = "jdbc:h2:~/jwp-basic;AUTO_SERVER=TRUE";
	private static final String DB_USERNAME = "sa";
	private static final String DB_PW = "";
	
	@Bean
	public BasicDataSource getDataSource() {
		BasicDataSource ds = new BasicDataSource();
		
		ds.setDriverClassName(DB_DRIVER);
		ds.setUrl(DB_URL);
		ds.setUsername(DB_USERNAME);
		ds.setPassword(DB_PW);
		
		return ds;
	}
	
	@Bean(name="springJdbcTemplate")
	public JdbcTemplate jdbcTemplate() { 
		return new JdbcTemplate(getDataSource());
	};

}
