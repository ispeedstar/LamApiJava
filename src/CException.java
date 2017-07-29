
public class CException {
	
	public static void doException()
	{
		try
		{
			doDividedByZero();
		}
		catch(Exception exception)
		{
			System.err.printf( "%s\n\n", exception.getMessage() );
	        exception.printStackTrace(); // print exception stack trace

	         // obtain the stack-trace information
	         StackTraceElement[] traceElements = exception.getStackTrace();
	         
	         System.out.println( "\nStack trace from getStackTrace:" );
	         System.out.println( "Class\t\tFile\t\t\tLine\tMethod" );

	         // loop through traceElements to get exception description
	         for ( StackTraceElement element : traceElements ) 
	         {
	            System.out.printf( "%s\t", element.getClassName() );
	            System.out.printf( "%s\t", element.getFileName() );
	            System.out.printf( "%s\t", element.getLineNumber() );
	            System.out.printf( "%s\n", element.getMethodName() );
	         } // end for

		}
	} // end doException

	public static void doDividedByZero() throws Exception 
	{
		try
		{
			int a = 5;
			double result = a/(a-a);
		}
		catch(Exception ex)
		{
			throw new Exception("Divided by Zero Error");
		} // end try-catch
		
	} // end doDividedByZero
} // end class
