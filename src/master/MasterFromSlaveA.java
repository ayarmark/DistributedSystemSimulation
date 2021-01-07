package master;
//c
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import job.Job;

public class MasterFromSlaveA extends Thread{

	public void run() {
		
		try {
			Job returnedJob;
			while((returnedJob = (Job)SharedMemory.slaveAIn.readObject()) != null) {
				System.out.println("Job " + returnedJob.getJobType() + " is complete.");
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
