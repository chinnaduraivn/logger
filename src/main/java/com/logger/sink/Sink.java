package com.logger.sink;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import com.logger.Level;
import com.logger.Message;

public abstract class Sink {

	private String timeFormat = null;
	private Set<Level> levels = null;
	private String sinkType = null;
	private DateFormat dateFormater = null;

	public Sink(String sinkType, Set<Level> levels, String timeFormat) {
		super();
		this.sinkType = sinkType;
		this.levels = levels;
		this.timeFormat = timeFormat;
		this.dateFormater = new SimpleDateFormat(timeFormat);
	}

	public Sink(String sinkType, Level level, String timeFormat) {
		super();
		Set<Level> levels = new HashSet<>();
		levels.add(level);
		this.sinkType = sinkType;
		this.levels = levels;
		this.timeFormat = timeFormat;
		this.dateFormater = new SimpleDateFormat(timeFormat);
	}

	public abstract void writeLog(Message message);

	public String getTimeFormat() {
		return timeFormat;
	}

	public Set<Level> getLevels() {
		return Collections.unmodifiableSet(levels);
	}

	public String getSinkType() {
		return sinkType;
	}

	public DateFormat getDateFormater() {
		return dateFormater;
	}

}
