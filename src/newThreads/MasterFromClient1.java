package newThreads;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import newClasses.Job;

public class MasterFromClient1 extends Thread{

	public void run() {
		
		try {
			Socket clientSocket = new Socket("127.0.0.1", 30152);
			ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
			Job returnedJob;
			while((returnedJob = (Job)in.readObject()) != null) {
				System.out.println("Received Job " + returnedJob.getJobType() + " from Client 1.");
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
