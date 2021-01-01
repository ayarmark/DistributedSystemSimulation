package newClasses;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.*;

import newClasses.Job;
import newClasses.JobType;
import newThreads.MasterFromClient1;
import newThreads.MasterFromSlaveA;
import newThreads.MasterToClient1;
import newThreads.MasterToSlaveA;

public class Master 
{
	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException
	{
		//receive job from client
		MasterFromClient1 masterFromClient1 = new MasterFromClient1();
		masterFromClient1.start();
		
		
	    //choose slave
		SharedMemory sharedMemory = new SharedMemory();
		Job job = new Job(JobType.A, 1);
		
		int aBusy = (sharedMemory.getNumAJobsSlaveA()*2)+(sharedMemory.getNumBJobsSlaveA()*10);
		int bBusy = (sharedMemory.getNumBJobsSlaveB()*2)+(sharedMemory.getNumAJobsSlaveB()*10);
		if(job.getJobType().equals(JobType.A)) {
			if(aBusy + 8 <= bBusy){
				//send to a
				MasterToSlaveA masterToSlaveA = new MasterToSlaveA();
				masterToSlaveA.start();
			} 
			else{
				//send to b
			}
		}
		else if(job.getJobType().equals(JobType.B)) {
			if(bBusy + 8 <= aBusy){
				//send to b
			} 
			else{
				//send to a
			}
		}
	    		
		//receive completed job from slave	
		MasterFromSlaveA masterFromSlaveA = new MasterFromSlaveA();
		masterFromSlaveA.start();
		
		//send back to client when complete
		//need to write code to send to the correct client
		MasterToClient1 masterToClient1 = new MasterToClient1();
		masterToClient1.start();
	   
	}	
}
