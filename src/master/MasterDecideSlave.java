package master;

import job.Job;
import job.JobType;

public class MasterDecideSlave extends Thread {
	public void run() {

		while (this.isAlive()) {
			Job j = Master.sharedMemory.jobsFromClients.peek();
			if (j != null) {
				/*
				 * System.out.println(); System.out.println("Update:");
				 * System.out.println("Jobs from Clients: " +
				 * Master.sharedMemory.jobsFromClients);
				 * System.out.println("Jobs to Send Slave A: "+Master.sharedMemory.
				 * jobsToSendSlaveA);
				 * System.out.println("Jobs to Send Slave B: "+Master.sharedMemory.
				 * jobsToSendSlaveB); System.out.println();
				 */
				// choose slave
				int aBusy = (Master.sharedMemory.numAJobsSlaveA * 2) + (Master.sharedMemory.numBJobsSlaveA * 10);
				int bBusy = (Master.sharedMemory.numBJobsSlaveB * 2) + (Master.sharedMemory.numAJobsSlaveB * 10);
				if (j.getJobType().equals(JobType.A)) {
					if (aBusy <= bBusy + 8) {
						// send to a
						Master.sharedMemory.jobsToSendSlaveA.add(j);
						synchronized (Master.sharedMemory) {
							Master.sharedMemory.numAJobsSlaveA++;
						}
						System.out.println("Chose to send " + j + " to Slave A");
						Master.sharedMemory.jobsFromClients.poll();
					} else {
						// send to b
						Master.sharedMemory.jobsToSendSlaveB.add(j);
						synchronized (Master.sharedMemory) {
							Master.sharedMemory.numAJobsSlaveB++;
						}
						System.out.println("Chose to send " + j + " to Slave B");
						Master.sharedMemory.jobsFromClients.poll();
					}
				} else { // if(sharedMemory.jobsToPerform.get(0).getJobType().equals(JobType.B))
					if (bBusy <= aBusy + 8) {
						// send to b
						Master.sharedMemory.jobsToSendSlaveB.add(j);
						synchronized (Master.sharedMemory) {
							Master.sharedMemory.numBJobsSlaveB++;
						}
						System.out.println("Chose to send " + j + " to Slave B");
						Master.sharedMemory.jobsFromClients.poll();
					} else {
						// send to a
						Master.sharedMemory.jobsToSendSlaveA.add(j);
						synchronized (Master.sharedMemory) {
							Master.sharedMemory.numBJobsSlaveA++;
						}
						System.out.println("Chose to send " + j + " to Slave A");
						Master.sharedMemory.jobsFromClients.poll();
					}
				}
			}
		}
	}
}
