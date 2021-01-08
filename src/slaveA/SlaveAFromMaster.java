package slaveA;

import java.io.IOException;

import job.Job;

public class SlaveAFromMaster extends Thread{
	public void run() {
		
		try {
			
			Job returnedJob;
			while((returnedJob = (Job)SlaveA.in.readObject()) != null) {
				System.out.println("Received " + returnedJob + " from Master.");
				SlaveA.jobsToDo.add(returnedJob);
				System.out.println("Jobs to do"+ SlaveA.jobsToDo);
			}
		} catch (IOException e2) {
			e2.printStackTrace();
		} catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
	}
}
