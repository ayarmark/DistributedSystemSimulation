
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.*;

import client.Job;
import client.JobType;
import write.WriteJob;

/**///added import write job
public class Master 
{

	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException{

		
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
<<<<<<< HEAD
		WriteJob write  = new WriteJob("127.0.0.1", 444);
	//	WriteJob write = new WriteJob(30121);
=======
		
		
		WriteJob write  = new WriteJob("127.0.0.1", 123);
>>>>>>> branch 'master' of https://github.com/ayarmark/MCON243FinalProject.git
		write.start();
		write.run();

		write.sendJob(job);
		

		//write.sendJob(job);

}}
