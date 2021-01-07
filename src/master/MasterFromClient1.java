package master;
//c
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import job.Job;

public class MasterFromClient1 extends Thread{
	public void run() {
		
		try {
			Job returnedJob;
			while((returnedJob = (Job)SharedMemory.client1In.readObject()) != null) {
				System.out.println("Received Job " + returnedJob.getJobID() + " " + returnedJob.getJobType() + " from Client 1.");
				Master.sharedMemory.jobsFromClients.add(returnedJob);
			}
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
	}
}
