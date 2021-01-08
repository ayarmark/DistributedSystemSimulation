package master;

import java.io.IOException;
import job.Job;
import job.JobType;

public class MasterFromSlaveB extends Thread {

	public void run() {

		try {
			Job returnedJob;
			while ((returnedJob = (Job) SharedMemory.slaveBIn.readObject()) != null) {
				System.out.println(returnedJob + " is complete.");
				Master.sharedMemory.jobsFromSlaves.add(returnedJob);
				if (returnedJob.getJobType().equals(JobType.A)) {
					synchronized (Master.sharedMemory) {
						Master.sharedMemory.numAJobsSlaveB--;
					}
				} else {
					synchronized (Master.sharedMemory) {
						Master.sharedMemory.numBJobsSlaveB--;
					}
				}
			}
		} catch (IOException e2) {
			e2.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
