package client2;

import java.util.Random;

import job.Job;
import job.JobType;

public class Client2CreateJobs extends Thread{
	public void run() {
		int clientID = 20;
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
    		Client2.jobsToDo.add(job);
		}
		while(true);
	}
}
