package slaveA;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import job.Job;
import job.JobType;

public class SlaveAToMaster extends Thread {
	public void run() {
		System.out.println("\n"+SlaveA.jobsFinished);
		try {
			while (true) {
				System.out.println("testing if we get here");
				
				// Job job = new Job(JobType.B, 2);
				// System.out.println("Sending complete Job " + job.getJobType() + " back to
				// master.");
				while(this.isAlive())
				{
					if(!SlaveA.jobsFinished.isEmpty()) 
					{
						System.out.println("Sending complete Job " + SlaveA.jobsFinished.peek().getJobType() + " back to master.");
						Memory.out.writeObject(SlaveA.jobsFinished.poll());
					}
				}
				
				/*
				 * while(this.isAlive()) { if(hasNewJob == true) { out.writeObject(job);
				 * hasNewJob = false; prevJobSent = true; } }
				 */
			}
		}

		catch (UnknownHostException e) {
			System.err.println("Don't know about host 127.0.0.1");
			System.exit(1);
		} catch (IOException ex) {
			ex.printStackTrace();
		//	System.err.println("Couldn't get I/O for the connection to 127.0.0.1");
			//System.exit(1);
		}
	}
}
