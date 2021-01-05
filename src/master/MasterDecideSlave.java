package master;

import job.JobType;

public class MasterDecideSlave  extends Thread{
	public void run() {
		while(!Master.sharedMemory.jobsFromClients.isEmpty()) {
		    //choose slave
			int aBusy = (Master.sharedMemory.getNumAJobsSlaveA()*2)+(Master.sharedMemory.getNumBJobsSlaveA()*10);
			int bBusy = (Master.sharedMemory.getNumBJobsSlaveB()*2)+(Master.sharedMemory.getNumAJobsSlaveB()*10);
			if(Master.sharedMemory.jobsFromClients.get(0).getJobType().equals(JobType.A)) {
				if(aBusy + 8 <= bBusy){
					//send to a
					Master.sharedMemory.jobsToSendSlaveA.add(Master.sharedMemory.jobsFromClients.get(0));
					Master.sharedMemory.jobsFromClients.remove(0);
				} 
				else{
					//send to b
					Master.sharedMemory.jobsToSendSlaveB.add(Master.sharedMemory.jobsFromClients.get(0));
					Master.sharedMemory.jobsFromClients.remove(0);
				}
			}
			else { //if(sharedMemory.jobsToPerform.get(0).getJobType().equals(JobType.B))
				if(bBusy + 8 <= aBusy){
					//send to b
					Master.sharedMemory.jobsToSendSlaveB.add(Master.sharedMemory.jobsFromClients.get(0));
					Master.sharedMemory.jobsFromClients.remove(0);
				} 
				else{
					//send to a
					Master.sharedMemory.jobsToSendSlaveA.add(Master.sharedMemory.jobsFromClients.get(0));
					Master.sharedMemory.jobsFromClients.remove(0);
				}
			}
			System.out.println(Master.sharedMemory.jobsFromClients);
			System.out.println(Master.sharedMemory.jobsToSendSlaveA);
			System.out.println(Master.sharedMemory.jobsToSendSlaveB);
		}
	}
}
