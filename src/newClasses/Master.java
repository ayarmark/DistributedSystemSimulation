package newClasses;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.*;
import java.util.ArrayList;

import newClasses.Job;
import newClasses.JobType;
import newThreads.MasterFromClient1;
import newThreads.MasterFromSlaveA;
import newThreads.MasterToClient1;
import newThreads.MasterToSlaveA;

public class Master 
{
	public static SharedMemory sharedMemory = new SharedMemory();
	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException
	{		
		//receive job from client
		MasterFromClient1 masterFromClient1 = new MasterFromClient1();
		masterFromClient1.start();
		
		/*MasterToSlaveA masterToSlaveA = new MasterToSlaveA();
		masterToSlaveA.start();*/
		
		while(!sharedMemory.jobsToPerform.isEmpty()) {
		    //choose slave
			int aBusy = (sharedMemory.getNumAJobsSlaveA()*2)+(sharedMemory.getNumBJobsSlaveA()*10);
			int bBusy = (sharedMemory.getNumBJobsSlaveB()*2)+(sharedMemory.getNumAJobsSlaveB()*10);
			if(sharedMemory.jobsToPerform.get(0).getJobType().equals(JobType.A)) {
				if(aBusy + 8 <= bBusy){
					//send to a
					sharedMemory.jobsToSendSlaveA.add(sharedMemory.jobsToPerform.get(0));
					sharedMemory.jobsToPerform.remove(0);
				} 
				else{
					//send to b
					sharedMemory.jobsToSendSlaveB.add(sharedMemory.jobsToPerform.get(0));
					sharedMemory.jobsToPerform.remove(0);
				}
			}
			else { //if(sharedMemory.jobsToPerform.get(0).getJobType().equals(JobType.B))
				if(bBusy + 8 <= aBusy){
					//send to b
					sharedMemory.jobsToSendSlaveB.add(sharedMemory.jobsToPerform.get(0));
					sharedMemory.jobsToPerform.remove(0);
				} 
				else{
					//send to a
					sharedMemory.jobsToSendSlaveA.add(sharedMemory.jobsToPerform.get(0));
					sharedMemory.jobsToPerform.remove(0);
				}
			}
		}
		
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
