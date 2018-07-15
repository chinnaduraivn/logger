package com.logger;

import java.util.Date;

import com.logger.configurer.LoggerConfigurer;
import com.logger.registry.Registry;

public final class Logger {

	private final static Logger logger = new Logger();

	public static Logger getLogger(LoggerConfigurer configurer) {
		if (configurer == null)
			throw new NullPointerException("LoggerConfigurer can not be null");
		configurer.configureLogger();
		return logger;
	}

	public void log(Message message) {

		if (message != null) {
			message.addTimeStamp(new Date());
			Registry.getSinksForLevel(message.getLevel()).forEach(sink -> sink.writeLog(message));
		}

	}

}
