package master;

import java.io.IOException;
import java.net.UnknownHostException;

import job.Job;

public class MasterToSlaveA extends Thread{
	public void run() {
		try
		{	
			while(this.isAlive())
			{
				Job j = Master.sharedMemory.jobsToSendSlaveA.peek();
				if( j !=null)
				{
					System.out.println("Sending " + j + " to slave.");
					SharedMemory.slaveAOut.writeObject(j);
					Master.sharedMemory.jobsToSendSlaveA.poll();
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
