package com.gid.gap;

import java.util.ArrayList;
import java.util.List;

public class Log {

	private List<LogEntry> logEntries = new ArrayList<LogEntry>();

	public void addLogEntry(LogEntry logEntry) {
		logEntries.add(logEntry);
	}

}
