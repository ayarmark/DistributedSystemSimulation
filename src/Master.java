
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.*;

import client.Job;
import client.JobType;
import write.WriteJob;

/**///added import write job
public class Master 
{
<<<<<<< HEAD
	public static void main(String[] args) throws UnknownHostException, IOException
=======
	public static void main(String[] args) throws InterruptedException
>>>>>>> branch 'master' of https://github.com/ayarmark/MCON243FinalProject.git
	{
		
		/**///start here
		Socket serverSocket = new Socket("127.0.0.1", 14725);
		ObjectInputStream in = new ObjectInputStream(serverSocket.getInputStream());
	     /**///ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
	    try {
			Job returnedJob = (Job)in.readObject();
			System.out.println(returnedJob.getJobType());
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     /**///end here
		
		Job job = new Job(JobType.A, 1);
		//Socket socket = new Socket();
		
		
		WriteJob write  = new WriteJob("127.0.0.1", 123);
		write.start();
		write.run();
<<<<<<< HEAD
		write.sendJob(job);
		
		
		
=======
		//write.sendJob(job);
>>>>>>> branch 'master' of https://github.com/ayarmark/MCON243FinalProject.git
	}	
}
