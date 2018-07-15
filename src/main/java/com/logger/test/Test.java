package com.logger.test;

import com.logger.Level;
import com.logger.Logger;
import com.logger.Message;
import com.logger.configurer.LoggerConfigurer;
import com.logger.configurer.TestAppLoggerConfigurer;

public class Test {

	public static void main(String[] args) {
		LoggerConfigurer configurer=new TestAppLoggerConfigurer();
		Logger logger=Logger.getLogger(configurer);
		Message message=new Message("This project is for Turvo", Level.DEBUG, Test.class.getName());
		logger.log(message);
		
		Message messageTwo=new Message("This project is about logger", Level.FATAL, Test.class.getName());
		logger.log(messageTwo);
	}
}
