import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class to perform various database commands
 * @author Stanley
 *
 */
public class DbTool {
	
	private static final String DB_URL = "jdbc:mysql://localhost:3306/dry_run"; // DB url and database name
	private static final String DB_USERNAME = "root";
	private static final String DB_PASSWORD = "root";
	
	private static Connection conn = null;
		
	
	/**
	 * connect to a database
	 */
	private static void connectDb()
	{
		try
		{
			conn = DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
		}
		catch(Exception ex)
		{
			conn = null;
			writeError("Error: unable to connectDb",ex);
		}
	}
	
	
	/**
	 * close database
	 */
	private static void closeDb()
	{
		if (conn != null)
		{
			try
			{
				conn.close();
			}
			catch(Exception ex)
			{
				writeError("Error: unable to closeDb",ex);
			}
		}
	}
	
	
	/**
	 * Test database connection
	 * @return
	 */
	public static boolean testConnection()
	{
		boolean result = false;
		try
		{
			connectDb();
			Thread.sleep(1000);
			closeDb();
			result = true;
		}
		catch(Exception ex)
		{
			writeError("Error: testConnection ", ex);
		}
		return(result);
	}
	
	
	/**
	 * Perform a database insert command
	 * @param command
	 * @return
	 */
	public static boolean performInsert(String command)
	{
		return(performNonQuery(command));
	}
	
	
	/**
	 * Perform a database update command
	 * @param command
	 * @return
	 */
	public static boolean performUpdate(String command)
	{
		return(performNonQuery(command));
	}
	
	
	/**
	 * Perform a database delete command
	 * @param command
	 * @return
	 */
	public static boolean performDelete(String command)
	{
		return(performNonQuery(command));
	}
	
	
	/**
	 * Perform a database command with no return value
	 * @param command
	 * @return
	 */
	public static boolean performNonQuery(String command)
	{
		boolean result = false;
		
		try
		{
			connectDb();
			Statement statement = conn.createStatement();
			int ret = statement.executeUpdate(command);
			result = true;
		}
		catch(Exception ex)
		{
			writeError("Error: performNonQuery() " + command,ex);
		}
		finally
        {
            closeDb();
        }
		return(result);
	}
	
	
	/**
	 * Perform a database command and return a scalar value
	 * @param command
	 * @return
	 */
	public static String fetchScalarQuery(String command)
	{
		String result = null;
		try
		{
			connectDb();
			Statement statement = conn.createStatement();
			statement.setFetchSize(1);
			ResultSet resultSet = statement.executeQuery(command);
			resultSet.next();
			result = resultSet.getObject(1).toString();
		}
		catch(Exception ex)
		{
			writeError("Error: fetchScalarQuery() " + command,ex);
		}
		finally
        {
            closeDb();
        }
		return(result);	
	}
	
	
	/**
	 * Perform a database command and return a column values
	 * @param command
	 * @return
	 */
	public static List fetchRowQuery(String command)
	{
		List<String> result = new ArrayList<String>();
		try
		{
			connectDb();
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(command);
			while(resultSet.next())
			{
				result.add(resultSet.getObject(1).toString());
			}
		}
		catch(Exception ex)
		{
			writeError("Error: fetchRowQuery() " + command,ex);
		}
		finally
        {
            closeDb();
        }
		return(result);	
	}
	
	
	/**
	 * Perform a database command and return a data set table
	 * @param command
	 * @return
	 */
	public static String[][] fetchDataSetQuery(String command)
	{
		List<String> list = new ArrayList<String>();
		String[][] result = null;
		try
		{
			connectDb();
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(command);
			
			// get metadata and column name
			ResultSetMetaData metaData = resultSet.getMetaData();
			int numCols = metaData.getColumnCount();
			for(int i=1;i<=numCols;i++)
			{
				list.add(metaData.getColumnName(i).toString());
			}
			
			// get row data
			while(resultSet.next())
			{
				for (int i=1;i<=numCols;i++)
				{
					list.add(resultSet.getObject(i).toString());
				}
			}
			
			// put data into 2D string array
			int numRows = list.size()/numCols-1;
			result = new String[numRows+1][numCols];
			int count = 0;
			for(String field:list)
			{
				result[(count/numCols)][count%numCols] = field;
				count++;
			}
			
		}
		catch(Exception ex)
		{
			writeError("Error: fetchDataSetQuery() " + command,ex);
		}
		finally
        {
            closeDb();
        }
		return(result);	
	}
	
	
	/**
	 * Write error 
	 * @param message
	 * @param ex
	 */
	private static void writeError(String message, Exception ex)
	{
		System.out.println(message + "; " + ex.getMessage());
	}

} // end class
