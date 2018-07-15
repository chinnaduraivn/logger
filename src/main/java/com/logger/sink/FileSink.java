package com.logger.sink;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Set;

import com.logger.Level;
import com.logger.Message;

public class FileSink extends Sink {

	private String filePath = null;

	public FileSink(String sinkType, Set<Level> levels, String timeFormat, String filePath) {
		super(sinkType, levels, timeFormat);
		this.filePath = filePath;

	}

	public FileSink(String sinkType, Level levels, String timeFormat, String filePath) {
		super(sinkType, levels, timeFormat);
		this.filePath = filePath;

	}

	@Override
	public void writeLog(Message message) {

		if (message == null)
			return;

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {

			String timeStamp = getDateFormater().format(message.getTimeStamp());
			String content = timeStamp + " : " + message.getNameSpace() + " : " + message.getContent()+"\n";
			bw.write(content);
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
