package master;

import java.io.IOException;
import job.Job;
import job.JobType;

public class MasterFromSlaveA extends Thread{

	public void run() {
		
		try {
			Job returnedJob;
			while((returnedJob = (Job)SharedMemory.slaveAIn.readObject()) != null) {
				System.out.println(returnedJob + " is complete.");
				Master.sharedMemory.jobsFromSlaves.add(returnedJob);
				if(returnedJob.getJobType().equals(JobType.A)) {
					Master.sharedMemory.numAJobsSlaveA--;
				}
				else {
					Master.sharedMemory.numBJobsSlaveA--;
				}
			}
			SharedMemory.serverSocketWithSlaveA.close();
		} catch (IOException e2) {
			e2.printStackTrace();
		} catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
	}
}
