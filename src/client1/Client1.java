package client1;

import java.io.*;
import java.net.*;
import java.util.concurrent.ConcurrentLinkedQueue;

import job.Job;


public class Client1 
{
	static ConcurrentLinkedQueue<Job> jobsToDo = new ConcurrentLinkedQueue<Job>();
	
	static Socket socketWithMaster;
	static ObjectOutputStream out;
	static ObjectInputStream in;
	
	public static void main(String [] args) throws UnknownHostException, IOException
	{
		socketWithMaster = new Socket("127.0.0.1", 1046);// connection going to MasterFromClient1
		out =  new ObjectOutputStream(socketWithMaster.getOutputStream());
		in = new ObjectInputStream(socketWithMaster.getInputStream());
		
		//creates 30 jobs
		Client1CreateJobs client1CreateJobs = new Client1CreateJobs();
		client1CreateJobs.start();
		
		//sends to master
		Client1ToMaster client1ToMaster = new Client1ToMaster();
		client1ToMaster.start();
		
		//receive from master
		Client1FromMaster client1FromMaster = new Client1FromMaster();
		client1FromMaster.start();
	}
}
