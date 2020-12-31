
import java.net.*;

import client.Job;
import client.JobType;


public class Master 
{
	public static void main(String[] args) throws InterruptedException
	{
		Job job = new Job(JobType.A, 1);
		//Socket socket = new Socket();
		
		
		WriteJob write  = new WriteJob("127.0.0.1", 123);
		write.start();
		write.run();
		//write.sendJob(job);
	}	
}
