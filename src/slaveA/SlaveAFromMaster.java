package slaveA;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import job.Job;

public class SlaveAFromMaster extends Thread{
	public void run() {
		
		try {
			Socket clientSocket = new Socket("127.0.0.1", 30154);
			ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
			Job returnedJob;
			while((returnedJob = (Job)in.readObject()) != null) {
				System.out.println("Received Job " + returnedJob.getJobType() + " from Master.");
			}
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
	}
}
