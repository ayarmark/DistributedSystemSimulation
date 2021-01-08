package master;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import job.Job;

public class MasterFromClient2 extends Thread{
	public void run() {
		
		try {
			
			ServerSocket serverSocketWithClient2 = new ServerSocket(1047);
			Socket clientSocketClient2 = serverSocketWithClient2.accept();
			SharedMemory.client2Out = new ObjectOutputStream(clientSocketClient2.getOutputStream());
			SharedMemory.client2In = new ObjectInputStream(clientSocketClient2.getInputStream());
			
			Job returnedJob;
			while((returnedJob = (Job)SharedMemory.client2In.readObject()) != null) {
				System.out.println("Received " + returnedJob + " from Client 2.");
				Master.sharedMemory.jobsFromClients.add(returnedJob);
			}
			serverSocketWithClient2.close();
		} catch (IOException e2) {
			e2.printStackTrace();
		} catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
	}
}
