package log4jpackage;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.log4j.*;

public class Log4Demo {
	
	static Logger log = Logger.getLogger(Log4Demo.class);

	public static void main(String[] args) throws IOException, SQLException {
		
		PropertyConfigurator.configure("log4j.properties");
		
		log.debug("Hello this is a DEBUG message");
		log.info("Hello this is an INFO message");
		log.warn("Hello this is an WARN message");
		log.error("Hello this is an ERROR message");
		log.fatal("Hello this is an FATAL message");
	}
}