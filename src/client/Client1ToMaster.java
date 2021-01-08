package client;

import java.io.IOException;
import java.net.UnknownHostException;


public class Client1ToMaster extends Thread{
	public void run() {
		try
		{	
			while(this.isAlive())
			{
				if(!Client.jobsToDo.isEmpty()) 
				{
					System.out.println("Sending " + Client.jobsToDo.peek() + " to master.");
					Client.out.writeObject(Client.jobsToDo.poll());
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
