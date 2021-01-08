package slaveB;

import java.io.IOException;
import java.net.UnknownHostException;

public class SlaveBToMaster extends Thread {
	public void run() {
		//System.out.println("\n"+SlaveB.jobsFinished);
		try {
			while (true) {

				while(this.isAlive())
				{
					if(!SlaveB.jobsFinished.isEmpty()) 
					{
						System.out.println("Sending complete " + SlaveB.jobsFinished.peek() + " back to master.");
						SlaveB.out.writeObject(SlaveB.jobsFinished.poll());
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
