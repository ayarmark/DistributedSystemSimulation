package slaveB;

import java.io.IOException;

import job.Job;

public class SlaveBFromMaster extends Thread{
	public void run() {
		
		try {
			
			Job returnedJob;
			while((returnedJob = (Job)SlaveB.in.readObject()) != null) {
				System.out.println("Received " + returnedJob + " from Master.");
				SlaveB.jobsToDo.add(returnedJob);
				System.out.println("Jobs to do"+ SlaveB.jobsToDo);
			}
		} catch (IOException e2) {
			e2.printStackTrace();
		} catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
	}
}
