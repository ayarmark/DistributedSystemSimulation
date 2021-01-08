package client2;

import java.io.IOException;
import java.net.UnknownHostException;


public class Client2ToMaster extends Thread{
	public void run() {
		try
		{	
			while(this.isAlive())
			{
				if(!Client2.jobsToDo.isEmpty()) 
				{
					System.out.println("Sending " + Client2.jobsToDo.peek() + " to master.");
					Client2.out.writeObject(Client2.jobsToDo.poll());
				}
			}
		}

		catch (UnknownHostException e) {
			System.err.println("Don't know about host 127.0.0.1");
			System.exit(1);
		} catch (IOException ex) {
			ex.printStackTrace();
			System.exit(1);
		}
	}
}
