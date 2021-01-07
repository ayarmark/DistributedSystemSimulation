package slaveA;
//c
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import job.Job;

public class SlaveAFromMaster extends Thread{
	public void run() {
		
		try {
			
			Job returnedJob;
			while((returnedJob = (Job)SlaveA.in.readObject()) != null) {
				System.out.println("Received Job " + returnedJob.getJobType() + " from Master.");
				SlaveA.jobsToDo.add(returnedJob);
				System.out.println("Jobs to do"+ SlaveA.jobsToDo);
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
