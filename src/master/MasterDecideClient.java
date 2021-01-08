package master;

import job.Job;

public class MasterDecideClient extends Thread{
	public void run() {
		
		while(this.isAlive())
		{
			Job j= Master.sharedMemory.jobsFromSlaves.peek();
			if( j != null)
			{
				System.out.println();
				System.out.println("Update:");
				System.out.println("Jobs from Slaves: " + Master.sharedMemory.jobsFromSlaves);
				System.out.println("Jobs to Send Client 1: "+Master.sharedMemory.jobsToSendClient1);
				System.out.println("Jobs to Send Client 2: "+Master.sharedMemory.jobsToSendClient2);
				System.out.println();
			    //choose client
				if(j.getClientID() == 10) {//send to client 1
					Master.sharedMemory.jobsToSendClient1.add(j);
					Master.sharedMemory.jobsFromSlaves.poll();
				}
				else { //send to client 2
					Master.sharedMemory.jobsToSendClient2.add(j);
					Master.sharedMemory.jobsFromSlaves.poll();
				}
			}
		}
	}
}
