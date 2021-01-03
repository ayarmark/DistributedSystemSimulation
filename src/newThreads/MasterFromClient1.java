package newThreads;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import newClasses.Job;
import newClasses.Master;

public class MasterFromClient1 extends Thread{
	public void run() {
		
		try {
			ServerSocket serverSocket = new ServerSocket(1046);
			Socket clientSocket = serverSocket.accept();
			ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
			Job returnedJob;
			while((returnedJob = (Job)in.readObject()) != null) {
				System.out.println("Received Job " + returnedJob.getJobType() + " from Client 1.");
				Master.sharedMemory.jobsToPerform.add(returnedJob);
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
