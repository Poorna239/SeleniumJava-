package log4j_Demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


 
public class Demo_Log4j {

	private static Logger logging = LogManager.getLogger(Demo_Log4j.class);
	
	public static void main(String[] args) {
		
		System.out.println("\n Hello World of java.... \n");
		
		logging.debug("This is a debug message");
		logging.info("This is an information message");
		logging.error("This is an error");
		logging.warn("This is a warning message");
		logging.fatal("This is a fatal message");
		

	}

}
