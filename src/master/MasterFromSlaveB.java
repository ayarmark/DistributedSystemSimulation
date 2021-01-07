package master;

import java.util.Random;

import job.Job;
import job.JobType;

public class MasterFromSlaveB extends Thread{
	public void run() {
	/*JobType jobType;
    Random rand = new Random();
	for(int i=0; i<30; i++) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 	if(rand.nextInt(10) == 1) {
	 		jobType = JobType.A;
	 	}
	 	else {
	 		jobType = JobType.B;
	 	}
		Job job = new Job(jobType, 10);
		System.out.println("Received from Slave B: " + jobType + ", with ID " + job.getJobID());
	}*/
	}
}
