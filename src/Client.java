


import java.io.*;
import java.net.*;
import java.util.Random;

import client.Job;
import client.JobType;
import writeAndRead.WriteJob;


public class Client 
{
	public static void main(String [] args) throws UnknownHostException, IOException
	{
		
		
	     int clientID = 10;//need to set
	     
	     JobType jobType;
	     Random rand = new Random();
	     WriteJob write  = new WriteJob("127.0.0.1", 14725);
	     write.start();
	     write.run();
	     
	     for(int i=0; i<30; i++) {
	    	 	if(rand.nextInt(2) == 1) {
	    	 		jobType = JobType.A;
	    	 	}
	    	 	else {
	    	 		jobType = JobType.B;
	    	 	}
	    		System.out.println("Sending request for job type " + jobType + "to server...");
	    		Job job = new Job(jobType, clientID);
	    	    write.sendJob(job);
        }

		/*
		args = new String[] {"127.0.0.1", "30122"};
    	
        if (args.length != 2) 
        {
            System.err.println( "Usage: java EchoClient <host name> <port number>");
            System.exit(1);
        }
        
		 String hostName = args[0];
	     int portNumber = Integer.parseInt(args[1]);
	     
	     Socket clientSocket = new Socket(hostName, portNumber);

	     ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
	     //ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
	     
	     try 
	     {
			Job returnedJob = (Job)in.readObject();
			System.out.println(returnedJob.getJobType());
	     } 
	     catch (ClassNotFoundException | IOException e) 
	     {
			e.printStackTrace();
	     }
	     */
	}
}