package master;

import job.Job;
import job.JobType;

public class MasterDecideSlave  extends Thread{
	public void run() {
		System.out.println(Master.sharedMemory.jobsFromClients);
		System.out.println(Master.sharedMemory.jobsToSendSlaveA);
		System.out.println(Master.sharedMemory.jobsToSendSlaveB);
		
		while(this.isAlive())
		{
			Job j= Master.sharedMemory.jobsFromClients.peek();
			if( j != null)
			{
				System.out.println("Jobs from Clients: " + Master.sharedMemory.jobsFromClients);
				System.out.println("Jobs to Send Slave A: "+Master.sharedMemory.jobsToSendSlaveA);
				System.out.println("Jobs to Send Slave B: "+Master.sharedMemory.jobsToSendSlaveB);
			    //choose slave
				int aBusy = (Master.sharedMemory.getNumAJobsSlaveA()*2)+(Master.sharedMemory.getNumBJobsSlaveA()*10);
				int bBusy = (Master.sharedMemory.getNumBJobsSlaveB()*2)+(Master.sharedMemory.getNumAJobsSlaveB()*10);
				if(j.getJobType().equals(JobType.A)) {
					if(aBusy + 8 <= bBusy){
						//send to a
						Master.sharedMemory.jobsToSendSlaveB.add(j);
						Master.sharedMemory.jobsFromClients.poll();//removes first one
					} 
					else{
						//send to b
						Master.sharedMemory.jobsToSendSlaveA.add(j);
						Master.sharedMemory.jobsFromClients.poll();
					}
				}
				else { //if(sharedMemory.jobsToPerform.get(0).getJobType().equals(JobType.B))
					if(bBusy + 8 <= aBusy){
						//send to b
						Master.sharedMemory.jobsToSendSlaveA.add(j);
						Master.sharedMemory.jobsFromClients.poll();
					} 
					else{
						//send to a
						Master.sharedMemory.jobsToSendSlaveB.add(j);
						Master.sharedMemory.jobsFromClients.poll();
					}
				}
			}
		}
	}
}
