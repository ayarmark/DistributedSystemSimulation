package slaveA;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.ConcurrentLinkedQueue;
import job.Job;

public class SlaveA {
	
	//by default the scope of this is package, only available to classes in slaveA package
	static ConcurrentLinkedQueue<Job> jobsToDo = new ConcurrentLinkedQueue<Job>();
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		//receive job from master
		SlaveAFromMaster slaveAFromMaster = new SlaveAFromMaster();
		slaveAFromMaster.start();
		
		//puts it in line
		//performs job and marks complete
		
		//send complete job back to master
		/*SlaveAToMaster slaveAToMaster = new SlaveAToMaster();
		slaveAToMaster.start();*/
	}
}
