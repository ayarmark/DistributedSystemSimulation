package slaveA;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.ConcurrentLinkedQueue;
import job.Job;
import job.JobType;

public class SlaveA {
	
	//by default the scope of this is package, only available to classes in slaveA package
	static ConcurrentLinkedQueue<Job> jobsToDo = new ConcurrentLinkedQueue<Job>();
	static ConcurrentLinkedQueue<Job> jobsFinished = new ConcurrentLinkedQueue<Job>();
	
	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
		//receive job from master
		SlaveAFromMaster slaveAFromMaster = new SlaveAFromMaster();
		slaveAFromMaster.start();
		

		
		//puts it in line
		//gets put in jobsToDo list in the SlaveAFromMaster thread
		
		// performs job and marks complete
		while (!jobsToDo.isEmpty()) {
			if(jobsToDo.peek().getJobType() == JobType.A) {
				SlaveAFromMaster.sleep(2000);
				jobsToDo.peek().setFinished(true);
				jobsFinished.add(jobsToDo.peek());
				//jobsToDo.poll();
				System.out.println("Job was type A");
			} else {
				SlaveAFromMaster.sleep(10000);
				jobsToDo.peek().setFinished(true);
				jobsFinished.add(jobsToDo.peek());
				//jobsToDo.poll();
				System.out.println("Job was type B");
			}
		}	
		//send complete job back to master
		//sends job back in SlaveAToMaster thread
		SlaveAToMaster slaveAToMaster = new SlaveAToMaster();
		slaveAToMaster.start();
	}
}