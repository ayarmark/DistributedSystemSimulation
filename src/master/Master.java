package master;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.*;
import java.util.ArrayList;

import job.Job;
import job.JobType;

public class Master 
{
	public static SharedMemory sharedMemory = new SharedMemory();
	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException
	{		
		//receive job from client
		MasterFromClient1 masterFromClient1 = new MasterFromClient1();
		MasterToSlaveA masterToSlaveA = new MasterToSlaveA();
		MasterDecideSlave masterDecideSlave = new MasterDecideSlave();
		masterFromClient1.start();
		masterToSlaveA.start();
		masterDecideSlave.start();
		
		/*while(!sharedMemory.jobsFromClients.isEmpty()) {
		    //choose slave
			int aBusy = (sharedMemory.getNumAJobsSlaveA()*2)+(sharedMemory.getNumBJobsSlaveA()*10);
			int bBusy = (sharedMemory.getNumBJobsSlaveB()*2)+(sharedMemory.getNumAJobsSlaveB()*10);
			if(sharedMemory.jobsFromClients.get(0).getJobType().equals(JobType.A)) {
				if(aBusy + 8 <= bBusy){
					//send to a
					sharedMemory.jobsToSendSlaveA.add(sharedMemory.jobsFromClients.get(0));
					sharedMemory.jobsFromClients.remove(0);
				} 
				else{
					//send to b
					sharedMemory.jobsToSendSlaveB.add(sharedMemory.jobsFromClients.get(0));
					sharedMemory.jobsFromClients.remove(0);
				}
			}
			else { //if(sharedMemory.jobsToPerform.get(0).getJobType().equals(JobType.B))
				if(bBusy + 8 <= aBusy){
					//send to b
					sharedMemory.jobsToSendSlaveB.add(sharedMemory.jobsFromClients.get(0));
					sharedMemory.jobsFromClients.remove(0);
				} 
				else{
					//send to a
					sharedMemory.jobsToSendSlaveA.add(sharedMemory.jobsFromClients.get(0));
					sharedMemory.jobsFromClients.remove(0);
				}
			}
			System.out.println(sharedMemory.jobsFromClients);
			System.out.println(sharedMemory.jobsToSendSlaveA);
			System.out.println(sharedMemory.jobsToSendSlaveB);
		}*/
		
	    /*	
		//receive completed job from slave	
		MasterFromSlaveA masterFromSlaveA = new MasterFromSlaveA();
		masterFromSlaveA.start();
		
		//send back to client when complete
		//need to write code to send to the correct client
		MasterToClient1 masterToClient1 = new MasterToClient1();
		masterToClient1.start();
	   */
	}	
}
