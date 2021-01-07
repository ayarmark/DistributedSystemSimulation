package master;
//c
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import job.Job;

public class SharedMemory 
{
	public int numAJobsSlaveA;
	public int numBJobsSlaveA;
	public int numAJobsSlaveB;
	public int numBJobsSlaveB;
	public ConcurrentLinkedQueue<Job> jobsFromClients;
	public ConcurrentLinkedQueue<Job> jobsToSendSlaveA;
	public ConcurrentLinkedQueue<Job> jobsToSendSlaveB;
	public ConcurrentLinkedQueue<Job> jobsFromSlaves;
	public ConcurrentLinkedQueue<Job> jobsToSendClient1;
	public ConcurrentLinkedQueue<Job> jobsToSendClient2;
	
	static ObjectInputStream slaveAIn;
	static ObjectOutputStream slaveAOut;
	
	public SharedMemory()
	{
		numAJobsSlaveA=0;
		numBJobsSlaveA=0;
		numAJobsSlaveB=0;
		numBJobsSlaveB=0;
		jobsFromClients = new ConcurrentLinkedQueue<Job>();
		jobsToSendSlaveA = new ConcurrentLinkedQueue<Job>();
		jobsToSendSlaveB = new ConcurrentLinkedQueue<Job>();
		jobsFromSlaves = new ConcurrentLinkedQueue<Job>();
		jobsToSendClient1 = new ConcurrentLinkedQueue<Job>();
		jobsToSendClient2 = new ConcurrentLinkedQueue<Job>();
		try
		{
			ServerSocket serverSocket = new ServerSocket(30154);
			Socket clientSocket = serverSocket.accept();
			slaveAOut =  new ObjectOutputStream(clientSocket.getOutputStream());
			slaveAIn = new ObjectInputStream(clientSocket.getInputStream());
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

