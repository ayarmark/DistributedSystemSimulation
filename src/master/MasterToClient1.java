package master;
//c
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import job.Job;
import job.JobType;

public class MasterToClient1 extends Thread{
	public void run() {
		try
		{
			while(this.isAlive())
			{
				Job j = Master.sharedMemory.jobsToSendClient1.peek();
				if( j !=null)
				{
					System.out.println("Sending Job " + j.getJobID() + " " + j.getJobType() + " back to Client.");
					SharedMemory.client1Out.writeObject(j);
					Master.sharedMemory.jobsToSendClient1.poll();
				}
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
