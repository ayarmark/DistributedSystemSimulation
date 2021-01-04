package master;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import job.Job;

public class MasterFromClient1 extends Thread{
	public void run() {
		
		try {
			ServerSocket serverSocket = new ServerSocket(1046);
			Socket clientSocket = serverSocket.accept();
			ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
			Job returnedJob;
			while((returnedJob = (Job)in.readObject()) != null) {
				System.out.println("Received Job " + returnedJob.getJobID() + " " + returnedJob.getJobType() + "  from Client 1.");
				Master.sharedMemory.jobsFromClients.add(returnedJob);
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
