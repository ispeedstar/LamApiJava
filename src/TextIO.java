
import java.io.*;

/**
 * 
 * Class to read and write to a text file
 *
 */
public class TextIO {
	
	private String filename;  
		
	
	public String getFilename()
	{
		return(filename);
	}
	
	
	public void setFilename(String file)
	{
		filename = file;
	}
	
	
	/**
	 * Read a text file
	 */
	public void readFile()
	{
		String line;
		
		try
		{
			FileReader fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			while((line=br.readLine()) != null)
			{
				if(!line.startsWith("#"))
				{
					String[] fields = line.split(";");
					for(String field : fields)
					{
						System.out.println(field);
					}
					System.out.println("");
				}
			} // end while
			
			br.close();
			fr.close();
			
		}
		catch(Exception ex)
		{
			System.out.println("Error: readFile " + filename + " " + ex.getMessage());
		}
		
	} //end readFile
	
	
	/**
	 * Write a text file
	 */
	public void writeFile()
	{
		File file = new File(filename);
		if (file.exists())
		{
			file.delete();
		}
		
		try
		{
			FileWriter fw = new FileWriter(filename);
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.write("LastName = Lam\n");
			bw.write("FirstName = Stanley\n");
			bw.write("Title = Software Engineer\n");
			bw.close();
			fw.close();
		}
		catch(Exception ex)
		{
			System.out.println("Error: unable to writeFile " + filename);
			
		}
	} // end writeFile

} // end class
