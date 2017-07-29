
class Worker extends Thread
{
	@Override
	public void run() {
		for (int i=0; i<5; i++)
		{
			System.out.println("Iteration: " + i);
			try
			{
				Thread.sleep(1000);
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			} // end try-catch
		} // end for loop
	} // end run
	
} // end class Worker

public class CThreads {
	
	public void doThreads()
	{
		Worker worker1  = new Worker();
		worker1.start();
		
		Worker worker2 = new Worker();
		worker2.start();
	}

}
