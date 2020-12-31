package client;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Random;
import writeAndRead.*;

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

		
		args = new String[] {"127.0.0.1", "30121"};
    	
        if (args.length != 2) {
            System.err.println(
                "Usage: java EchoClient <host name> <port number>");
            System.exit(1);
        }
        
		 String hostName = args[0];
	     int portNumber = Integer.parseInt(args[1]);
	     
	     Socket clientSocket = new Socket(hostName, portNumber);

	     System.out.println(clientSocket.getInetAddress());



	     
	     ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
	     try {
			Job returnedJob = (Job)in.readObject();
			System.out.println(returnedJob.getJobType());
		} 
	     catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	clientSocket.close();

	     

	}
}
