package master;

import java.io.IOException;

import job.Job;

public class MasterFromClient2 extends Thread{
	public void run() {
		
		try {
			
			Job returnedJob;
			while((returnedJob = (Job)SharedMemory.client2In.readObject()) != null) {
				System.out.println("Received " + returnedJob + " from Client 2.");
				Master.sharedMemory.jobsFromClients.add(returnedJob);
			}
		} catch (IOException e2) {
			e2.printStackTrace();
		} catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
	}
}
