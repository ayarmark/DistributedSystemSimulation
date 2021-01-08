package client;

import java.util.Random;

import job.Job;
import job.JobType;

public class Client1CreateJobs extends Thread{
	public void run() {
		int clientID = 10;
		JobType jobType;
	    Random rand = new Random();
		for(int i=0; i<30; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
    	 	if(rand.nextInt(2) == 1) {
    	 		jobType = JobType.A;
    	 	}
    	 	else {
    	 		jobType = JobType.B;
    	 	}
    		Job job = new Job(jobType, clientID);
    		System.out.println("User entered request for " + job);
    		Client.jobsToDo.add(job);
		}
		while(true);
	}
}
