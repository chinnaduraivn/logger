package com.logger;

import java.util.Date;

public class Message {

	private String content;
	private Level level;
	private String nameSpace;
	private Date timeStamp;

	public Message(String content, Level level, String nameSpace) {
		super();
		this.content = content;
		this.level = level;
		this.nameSpace = nameSpace;
	}

	public String getContent() {
		return content;
	}

	public Level getLevel() {
		return level;
	}

	public String getNameSpace() {
		return nameSpace;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void addTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

}
