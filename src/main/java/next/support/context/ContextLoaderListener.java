package next.support.context;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Component;

import core.jdbc.ConnectionManager;


@Component
public class ContextLoaderListener {
	private static final Logger logger = LoggerFactory.getLogger(ContextLoaderListener.class);
	
	@Autowired
	public DataSource dataSource;
	
	@PostConstruct
	public void contextInitialized() {
		ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
		populator.addScript(new ClassPathResource("jwp.sql"));
		DatabasePopulatorUtils.execute(populator, dataSource);
		
		logger.info("Completed Load ServletContext!");
	}

}
