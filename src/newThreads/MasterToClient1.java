package newThreads;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import newClasses.Job;
import newClasses.JobType;

public class MasterToClient1 extends Thread{
	public void run() {
		try
		{
			ServerSocket serverSocket = new ServerSocket(30151);
			while(true)
			{
				Socket clientSocket = serverSocket.accept();
				ObjectOutputStream out =  new ObjectOutputStream(clientSocket.getOutputStream());
				Job job = new Job(JobType.B, 2);
				System.out.println("Sending complete Job " + job.getJobType() + " back to the client.");
				out.writeObject(job);

				/*while(this.isAlive())
		    {
		    	if(hasNewJob == true)
		    	{
		    		out.writeObject(job);
		    		hasNewJob = false;
		    		prevJobSent = true;
		    	}
		    }*/
			}
		}

		catch (UnknownHostException e) {
			System.err.println("Don't know about host 127.0.0.1");
			System.exit(1);
		} catch (IOException ex) {
			System.err.println("Couldn't get I/O for the connection to 127.0.0.1");
			System.exit(1);
		} 
	}
}
