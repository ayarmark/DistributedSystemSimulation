package slaveA;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.ConcurrentLinkedQueue;
import job.Job;
import job.JobType;

public class SlaveA {
	
	//by default the scope of this is package, only available to classes in slaveA package
	static ConcurrentLinkedQueue<Job> jobsToDo = new ConcurrentLinkedQueue<Job>();
	static ConcurrentLinkedQueue<Job> jobsFinished = new ConcurrentLinkedQueue<Job>();
	
	static Socket clientSocket;
	static ObjectInputStream in;
	static ObjectOutputStream out;
	
	
	
	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
		
		//initializes in/output streams with master
		try 
		{
			clientSocket = new Socket("127.0.0.1", 30154);
			in = new ObjectInputStream(clientSocket.getInputStream());
			out = new ObjectOutputStream(clientSocket.getOutputStream());	
		
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} 
		
		
		//receive job from master
		SlaveAFromMaster slaveAFromMaster = new SlaveAFromMaster();
		slaveAFromMaster.start();
		
		//send complete job back to master
		SlaveAToMaster slaveAToMaster = new SlaveAToMaster();
		slaveAToMaster.start();
		

		
		//puts it in line
		//gets put in jobsToDo list in the SlaveAFromMaster thread
		
		// performs job and marks complete
		boolean done=false;
		while (!done) 
		{
			if (!jobsToDo.isEmpty()) 
			{
				if(jobsToDo.peek().getJobType() == JobType.A) 
				{
					Thread.sleep(2000);
					jobsToDo.peek().setFinished(true);
					jobsFinished.add(jobsToDo.peek());
					System.out.println("Completed " + jobsToDo.peek());
					jobsToDo.poll();
				} 
				else 
				{
					Thread.sleep(10000);
					jobsToDo.peek().setFinished(true);
					jobsFinished.add(jobsToDo.peek());
					System.out.println("Completed " + jobsToDo.peek());
					jobsToDo.poll();
				}
			}
			
		}
		

	}
}