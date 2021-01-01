package probablyGarbage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.*;

import client.Job;
import client.JobType;
import writeAndRead.*;

public class Master 
{
	public static void main(String[] args) throws /*UnknownHostException, IOException,*/ InterruptedException
	{
		/*
		//start here
		Socket serverSocket = new Socket("127.0.0.1", 1024);
		ObjectInputStream in = new ObjectInputStream(serverSocket.getInputStream());
	    try {
			Job returnedJob = (Job)in.readObject();
			System.out.println(returnedJob.getJobType());
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    //end here
		*/
		
		Job job = new Job(JobType.A, 1);
		
		WriteJob write  = new WriteJob("127.0.0.1", 123);
		write.start();
		//write.run();

		write.sendJob(job);
	}
}
