package master;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentLinkedQueue;

import job.Job;

public class SharedMemory 
{
	int numAJobsSlaveA;
	int numBJobsSlaveA;
	int numAJobsSlaveB;
	int numBJobsSlaveB;
	
	ConcurrentLinkedQueue<Job> jobsFromClients;
	ConcurrentLinkedQueue<Job> jobsToSendSlaveA;
	ConcurrentLinkedQueue<Job> jobsToSendSlaveB;
	ConcurrentLinkedQueue<Job> jobsFromSlaves;
	ConcurrentLinkedQueue<Job> jobsToSendClient1;
	ConcurrentLinkedQueue<Job> jobsToSendClient2;
	
	static ObjectInputStream slaveAIn;
	static ObjectOutputStream slaveAOut;
	static ObjectInputStream slaveBIn;
	static ObjectOutputStream slaveBOut;
	static ObjectInputStream client1In;
	static ObjectOutputStream client1Out;
	static ObjectInputStream client2In;
	static ObjectOutputStream client2Out;
	static ServerSocket serverSocketWithSlaveA;
	static ServerSocket serverSocketWithSlaveB;
	
	public SharedMemory()
	{
		
		
		try 
		{
			serverSocketWithSlaveA = new ServerSocket(30154);
			Socket clientSocketSlaveA = serverSocketWithSlaveA.accept();
			SharedMemory.slaveAOut =  new ObjectOutputStream(clientSocketSlaveA.getOutputStream());
			SharedMemory.slaveAIn = new ObjectInputStream(clientSocketSlaveA.getInputStream());
			
			serverSocketWithSlaveB = new ServerSocket(30160);
			Socket clientSocketSlaveB = serverSocketWithSlaveB.accept();
			SharedMemory.slaveBOut =  new ObjectOutputStream(clientSocketSlaveB.getOutputStream());
			SharedMemory.slaveBIn = new ObjectInputStream(clientSocketSlaveB.getInputStream());
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
			
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
		
	}
}

