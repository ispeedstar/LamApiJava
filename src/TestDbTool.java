import java.util.List;

/**
 * Class to test various database command
 *
 */
public class TestDbTool {
	
	
	public void testDbConnection()
	{
		DbTool.testConnection();
	}
	
	
	public boolean testPerformInsert()
	{
		boolean result = false;
		 String command = "INSERT INTO `salesrep` (Srepno,Srepname,Srepstreet,Srepcity,Srepprov,Sreppcode,Totcomm,Commrate) VALUES('STL','Stanley Lam', '1187 Gatewood', 'London', 'ON', 'A1B2C3',99.9,9.9)";
         result = DbTool.performInsert(command);
         return (result);
	}
	
	
	public boolean testPerformUpdate()
    {
        boolean result = false;
        String command = "UPDATE `salesrep` SET Srepprov='BC' WHERE Srepno='STL'";
        result = DbTool.performUpdate(command);
        return (result);
    }

	
    public boolean testPerformDelete()
    {
        boolean result = false;
        String command = "DELETE FROM `salesrep` WHERE Srepno='STL'";
        result = DbTool.performDelete(command);
        return (result);
    }
    
    
    public boolean testFetchScalarQuery()
    {
        boolean result = false;
        String command = "SELECT Srepname FROM `salesrep` WHERE Srepname='John Doe'";
        String data = DbTool.fetchScalarQuery(command);
        result = true;
        return (result);
    }

    
    public boolean testFetchRowQuery()
    {
        boolean result = false;
        String command = "SELECT Srepname FROM `salesrep`";
        List data = DbTool.fetchRowQuery(command);
        result = true;
        return (result);
    }

    
    public boolean testFetchDataSetQuery()
    {
        boolean result = false;
        String command = "SELECT * FROM `salesrep`";
        String[][] data = DbTool.fetchDataSetQuery(command);
        result = true;
        return (result);
    }

    
    public boolean testAll()
    {
        boolean result = false;
        testDbConnection();
        testPerformInsert();
        testPerformUpdate();
        testPerformDelete();
        testFetchScalarQuery();
        testFetchRowQuery();
        testFetchDataSetQuery();
        result = true;
        return (result);
    }

} // end class TestDbTool
