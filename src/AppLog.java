import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Class to write message to log file and console
 *
 */
public class AppLog {
	
	private String filename; // log file name
	
	
	public AppLog(String file)
	{
		setFilename(file);
	}
	
	
	public void setFilename(String file)
	{
		filename = file;
	}

	
	public String getFilename()
	{
		return(filename);
	}
	
	
	/**
	 * Append message to log file
	 * @param message
	 */
	public void addToFile(String message)
	{
		try
		{
			FileWriter fileWriter = new FileWriter(filename,true);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write(setLogMessage(message));
			bufferedWriter.close();
			fileWriter.close();
		}
		catch(Exception ex)
		{
			System.out.println("Error: unable to log " + message + ", " + ex.getMessage());
		}
	}
	
	
	/**
	 * Add message to console
	 */
	public void addToConsole(String message)
	{
		System.out.print(setLogMessage(message));
	}
	
	
	/**
	 * Add message to log file and console
	 * @param message
	 */
	public void addToFileAndConsole(String message)
	{
		addToFile(message);
		addToConsole(message);
	}
	
	
	/**
	 * Set log message statement
	 * @param message
	 * @return
	 */
	private String setLogMessage(String message) {
		StringBuilder sb = new StringBuilder();
		sb.append(getDateTime());
		sb.append(", ");
		sb.append(message);
		sb.append("\n");
		return sb.toString();
	}
	
	
	/**
	 * Get date and time 
	 * @return
	 */
	private String getDateTime()
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		return(dateFormat.format(date));
	}
	
} // end class AppLog
