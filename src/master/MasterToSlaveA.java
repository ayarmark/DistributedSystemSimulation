package master;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import job.Job;
import job.JobType;

public class MasterToSlaveA extends Thread{
	public void run() {
		try
		{
			ServerSocket serverSocket = new ServerSocket(30154);
			while(!Master.sharedMemory.jobsToSendSlaveA.isEmpty())
			{
				Socket clientSocket = serverSocket.accept();
				ObjectOutputStream out =  new ObjectOutputStream(clientSocket.getOutputStream());
				System.out.println("Sending Job " + Master.sharedMemory.jobsToSendSlaveA.get(0).getJobType() + " to slave.");
				out.writeObject(Master.sharedMemory.jobsToSendSlaveA.get(0));
				Master.sharedMemory.jobsToSendSlaveA.remove(0);
			}
		}

		catch (UnknownHostException e) {
			System.err.println("Don't know about host 127.0.0.1");
			System.exit(1);
		} catch (IOException ex) {
			System.err.println("Couldn't get I/O for the connection to 127.0.0.1");
			System.exit(1);
		} 
	}
}
