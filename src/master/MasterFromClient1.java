package master;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import job.Job;

public class MasterFromClient1 extends Thread{
	public void run() {
		
		try {
			ServerSocket serverSocketWithClient1 = new ServerSocket(1046);
			Socket clientSocketClient1 = serverSocketWithClient1.accept();
			SharedMemory.client1Out = new ObjectOutputStream(clientSocketClient1.getOutputStream());
			SharedMemory.client1In = new ObjectInputStream(clientSocketClient1.getInputStream());
			
			Job returnedJob;
			while((returnedJob = (Job)SharedMemory.client1In.readObject()) != null) {
				System.out.println("Received " + returnedJob + " from Client 1.");
				Master.sharedMemory.jobsFromClients.add(returnedJob);
			}
			serverSocketWithClient1.close();
		} catch (IOException e2) {
			e2.printStackTrace();
		} catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
	}
}
