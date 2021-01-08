package master;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
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
	static ObjectInputStream slaveBIn;
	static ObjectOutputStream slaveBOut;
	static ObjectInputStream client1In;
	static ObjectOutputStream client1Out;
	static ObjectInputStream client2In;
	static ObjectOutputStream client2Out;
	
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
			ServerSocket serverSocketWithSlaveA = new ServerSocket(30154);
			Socket clientSocketSlaveA = serverSocketWithSlaveA.accept();
			slaveAOut =  new ObjectOutputStream(clientSocketSlaveA.getOutputStream());
			slaveAIn = new ObjectInputStream(clientSocketSlaveA.getInputStream());
			
			ServerSocket serverSocketWithSlaveB = new ServerSocket(30160);
			Socket clientSocketSlaveB = serverSocketWithSlaveB.accept();
			slaveBOut =  new ObjectOutputStream(clientSocketSlaveB.getOutputStream());
			slaveBIn = new ObjectInputStream(clientSocketSlaveB.getInputStream());
			
			ServerSocket serverSocketWithClient1 = new ServerSocket(1046);
			Socket clientSocketClient1 = serverSocketWithClient1.accept();
			client1Out = new ObjectOutputStream(clientSocketClient1.getOutputStream());
			client1In = new ObjectInputStream(clientSocketClient1.getInputStream());
			
			ServerSocket serverSocketWithClient2 = new ServerSocket(1047);
			Socket clientSocketClient2 = serverSocketWithClient2.accept();
			client2Out = new ObjectOutputStream(clientSocketClient2.getOutputStream());
			client2In = new ObjectInputStream(clientSocketClient2.getInputStream());
			
			
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

