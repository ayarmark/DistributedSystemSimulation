package client2;

import java.io.*;
import java.net.*;
import java.util.concurrent.ConcurrentLinkedQueue;

import job.Job;


public class Client2 
{
	static ConcurrentLinkedQueue<Job> jobsToDo = new ConcurrentLinkedQueue<Job>();
	
	static Socket socketWithMaster;
	static ObjectOutputStream out;
	static ObjectInputStream in;
	
	public static void main(String [] args) throws UnknownHostException, IOException
	{
		socketWithMaster = new Socket("127.0.0.1", 1047);// connection going to MasterFromClient1
		out =  new ObjectOutputStream(socketWithMaster.getOutputStream());
		in = new ObjectInputStream(socketWithMaster.getInputStream());
		
		//creates 30 jobs
		Client2CreateJobs client2CreateJobs = new Client2CreateJobs();
		client2CreateJobs.start();
		
		//sends to master
		Client2ToMaster client2ToMaster = new Client2ToMaster();
		client2ToMaster.start();
		
		//receive from master
		Client2FromMaster client2FromMaster = new Client2FromMaster();
		client2FromMaster.start();
	}
}
