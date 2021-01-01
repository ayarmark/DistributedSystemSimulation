package writeAndRead;


import java.lang.Thread;
import java.net.*;
import java.io.*;
import java.util.*;
import client.Job;
import client.JobType;



public class WriteJob extends Thread 
{
	String hostNum;
	int socketNum;
	Job job;
	Job currJob;
	boolean hasNewJob = false;
	boolean prevJobSent = true;
	String [] args = new String[] { "30122" };
	
	//giving error not sure why
	/*if (args.length != 1) {
		System.err.println("Usage: java EchoServer <port number>");
		System.exit(1);
	}*/
	
	int portNumber = Integer.parseInt(args[0]);
	
	
	public WriteJob(String hostNum, int socketNum)
	{
		this.hostNum = hostNum;
		this.socketNum = socketNum;

	}
	
	public void run() {
		try
		{
			ServerSocket serverSocket = new ServerSocket(portNumber);
			while(true)
			{
				Socket clientSocket = serverSocket.accept();
			    ObjectOutputStream out =  new ObjectOutputStream(clientSocket.getOutputStream());
			    job = new Job(JobType.B, 2);
			    out.writeObject(job);
			    
			    /*while(this.isAlive())
			    {
			    	if(hasNewJob == true)
			    	{
			    		out.writeObject(job);
			    		hasNewJob = false;
			    		prevJobSent = true;
			    	}
			    }*/
			}
		}
		
		catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostNum);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " +
                hostNum);
            System.exit(1);
        } 
	
	}
	
	public void sendJob(Job job)
	{
		while( ! prevJobSent );
		this.job=job;
		hasNewJob = true;
		prevJobSent = false;
	}
}



