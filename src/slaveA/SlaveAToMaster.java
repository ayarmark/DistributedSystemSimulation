package slaveA;

import java.io.IOException;
import java.net.UnknownHostException;

public class SlaveAToMaster extends Thread {
	public void run() {
		System.out.println("\n"+SlaveA.jobsFinished);
		try {
			while (true) {

				while(this.isAlive())
				{
					if(!SlaveA.jobsFinished.isEmpty()) 
					{
						System.out.println("Sending complete " + SlaveA.jobsFinished.peek() + " back to master.");
						SlaveA.out.writeObject(SlaveA.jobsFinished.poll());
					}
				}
			}
		}

		catch (UnknownHostException e) {
			System.err.println("Don't know about host 127.0.0.1");
			System.exit(1);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
