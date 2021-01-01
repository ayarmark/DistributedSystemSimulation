package newThreads;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;
import newClasses.Job;
import newClasses.JobType;


public class Client1ToMaster extends Thread{
	public void run() {
		int clientID = 10;
		
		try
		{	
			Socket socket = new Socket("127.0.0.1", 1046);// connection going to MasterFromClient1
			while(true)
			{
				ObjectOutputStream out =  new ObjectOutputStream(socket.getOutputStream());
				
				//create jobs and send
				JobType jobType;
			    Random rand = new Random();
				for(int i=0; i<30; i++) {
					Thread.sleep(1000);
		    	 	if(rand.nextInt(2) == 1) {
		    	 		jobType = JobType.A;
		    	 	}
		    	 	else {
		    	 		jobType = JobType.B;
		    	 	}
		    		System.out.println("Created request for job type " + jobType);
		    		Job job = new Job(jobType, clientID);
		    		out.writeObject(job);
				}
			}
		}

		catch (UnknownHostException e) {
			System.err.println("Don't know about host 127.0.0.1");
			System.exit(1);
		} catch (IOException ex) {
			//System.err.println("Couldn't get I/O for the connection to 127.0.0.1");
			ex.printStackTrace();
			System.exit(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
