package com.gid.gap;

import java.io.File;
import java.io.IOException;

import org.apache.commons.digester3.Digester;
import org.xml.sax.SAXException;

public class Main {

	public static void main(String[] args) throws IOException, SAXException {
		Digester digester = new Digester();
		digester.setValidating(false);

		digester.addObjectCreate("log", Log.class);

		digester.addObjectCreate("log/logentry", LogEntry.class);
		digester.addSetNext("log/logentry", "addLogEntry");

		digester.addObjectCreate("log/logentry/paths", Paths.class);
		digester.addSetNext("log/logentry/paths", "addPaths");

		digester.addObjectCreate("log/logentry/paths/path", Path.class);
		digester.addSetProperties("log/logentry/paths/path", "action", "action");
		digester.addBeanPropertySetter("log/logentry/paths/path", "path");
		digester.addSetNext("log/logentry/paths/path", "addPath");

		Log svnLog = (Log) digester.parse(new File(
				"/Users/cbushell/Dropbox/dev/svn-metrics/data/svn_dump.log"));
	}

}
