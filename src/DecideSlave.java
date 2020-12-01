import client.*;//should we really import *?

public class DecideSlave {
	public static void main(String[] args) {
		//will receive somehow
		SharedMemory sharedMemory = new SharedMemory();
		Job job = new Job(JobType.A, 1);
		
		int aBusy = (sharedMemory.getNumAJobsSlaveA()*2)+(sharedMemory.getNumBJobsSlaveA()*10);
		int bBusy = (sharedMemory.getNumBJobsSlaveB()*2)+(sharedMemory.getNumAJobsSlaveB()*10);
		if(job.getJobType().equals(JobType.A)) {
			if(aBusy + 8 <= bBusy){
				//send to a
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
	}
}
