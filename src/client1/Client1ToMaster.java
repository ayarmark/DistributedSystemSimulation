package client1;

import java.io.IOException;
import java.net.UnknownHostException;


public class Client1ToMaster extends Thread{
	public void run() {
		try
		{	
			while(this.isAlive())
			{
				if(!Client1.jobsToDo.isEmpty()) 
				{
					System.out.println("Sending " + Client1.jobsToDo.peek() + " to master.");
					Client1.out.writeObject(Client1.jobsToDo.poll());
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
