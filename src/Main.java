import org.apache.log4j.Logger;


public class Main {
	
	private static Logger logger = Logger.getLogger(Main.class); // apply log4j to log message from log4j.properties
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		CThreads t = new CThreads();
		t.doThreads();
		
		
		/*CException myEx = new CException();
		myEx.doException();*/
		
		
		/*AppLog appLog = new AppLog("C:\\temp\\LamAPIAppLog.txt");
		System.out.println("Start Application");
		logger.info("--- Start Application ---");
		appLog.addToFileAndConsole("--- Start Application ---");
		TextIO textIO2 = new TextIO();*/
		
		/*logger.info("Test readFile and writeFile text file.");
		TextIO textIO = new TextIO();
		textIO.setFilename("C:\\Projects\\exer\\VS2010\\Data\\userInfo.txt");
		textIO.readFile();
		textIO.setFilename("C:\\Projects\\exer\\VS2010\\Data\\userInfo.out");
		textIO.writeFile();
		
		logger.info("Test all DB commands.");
		TestDbTool testDb = new TestDbTool();
		testDb.testAll();
		
		logger.info("Test readFile and writeFile XML file.");
		XmlIO xmlIO = new XmlIO();
		xmlIO.setFilename("C:\\Projects\\exer\\VS2010\\Data\\userInfo.xml");
		xmlIO.readFile();
		xmlIO.setFilename("C:\\Projects\\exer\\VS2010\\Data\\userInfoOut.xml");
		xmlIO.writeFile();*/
		
		/*logger.info("Test all data collection.");
		DataCollection dc = new DataCollection();
		dc.doAll();
		
		logger.info("--- End Application ---");*/
	} // end main

} // end class Main
