package com.logger.configurer;

import java.util.HashSet;
import java.util.Set;

import com.logger.Level;
import com.logger.registry.Registry;
import com.logger.sink.FileSink;
import com.logger.sink.Sink;

public class TestAppLoggerConfigurer implements LoggerConfigurer {

	@Override
	public void configureLogger() {

		Sink fileSinkOne = new FileSink("File", Level.DEBUG, "dd-M-yyyy hh:mm:ss", "logOne.txt");
		Registry.registerSink(fileSinkOne);

		Set<Level> levels = new HashSet<>();
		levels.add(Level.DEBUG);
		levels.add(Level.ERROR);
		levels.add(Level.FATAL);

		Sink fileSinkTwo = new FileSink("File", levels, "dd-M-yyyy hh:mm:ss", "logTwo.txt");
		Registry.registerSink(fileSinkTwo);
	}

}
