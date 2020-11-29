import java.lang.Thread;
import java.net.*;
import java.io.*;
import java.util.*;
import client.Job;



public class WriteJob extends Thread
{
	String hostNum;
	int socketNum;
	Job job;
	Job currJob;
	boolean hasNewJob = false;
	boolean prevJobSent = true;
	
	
	public WriteJob(String hostNum, int socketNum)
	{
		this.hostNum=hostNum;
		this.socketNum=socketNum;
	}
	
	public void run()
	{
		try
		{
			ServerSocket serverSocket = new ServerSocket(socketNum);
			Socket clientSocket = serverSocket.accept();
		    ObjectOutputStream out =  new ObjectOutputStream(clientSocket.getOutputStream());
		    
		    while(this.isAlive())
		    {
		    	if(hasNewJob == true)
		    	{
		    		out.writeObject(job);
		    		hasNewJob = false;
		    		prevJobSent = true;
		    	}
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