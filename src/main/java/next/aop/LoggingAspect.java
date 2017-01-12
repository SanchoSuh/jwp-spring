package next.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
	private static final Logger log = LoggerFactory.getLogger(LoggingAspect.class);
	
	@Before("within(next.dao..*)")
	public void logging(JoinPoint jp) {
		Object[] args = jp.getArgs();
		for(Object arg : args) {
			log.debug(jp.toShortString());
			log.debug(arg + " ");
		}
			
	}
}
