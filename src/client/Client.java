package client;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Random;

import write.WriteJob;
public class Client 
{
	public static void main(String [] args) throws UnknownHostException, IOException
	{
		
	     /**///start here
	     /**///moved writejob to new package
	     int clientID = 10;//need to set
	     
	     //System.out.print("Enter A or B for the type of job you want to perform: ");
	     //BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
	     //String userInput;
	     JobType jobType;
	     Random rand = new Random();
	     WriteJob write  = new WriteJob("127.0.0.1", 14725);
	     write.start();
	     write.run();
	     
	     //while ((userInput = stdIn.readLine()) != null) {
	     for(int i=0; i<30; i++) {
	    	 //if(userInput.toUpperCase() == "A" || userInput.toUpperCase() == "B") {
	    	 	if(rand.nextInt(2) == 1) {
	    	 		jobType = JobType.A;
	    	 	}
	    	 	else {
	    	 		jobType = JobType.B;
	    	 	}
	    		//jobType = JobType.valueOf(userInput);
	    		System.out.println("Sending request for job type " + jobType + "to server...");
	    		Job job = new Job(jobType, clientID);
	    	    write.sendJob(job);
	    	 //}
	    	 //else {
	    	 //	 System.out.println("That is not a correct choice.");
	    	 //}             
             //System.out.print("Enter A or B for the next type of job you want to perform: ");
         }
	     
	     /**///end here
		
>>>>>>> branch 'master' of https://github.com/ayarmark/MCON243FinalProject.git
		args = new String[] {"127.0.0.1", "30121"};
    	
        if (args.length != 2) {
            System.err.println(
                "Usage: java EchoClient <host name> <port number>");
            System.exit(1);
        }
        
		 String hostName = args[0];
	     int portNumber = Integer.parseInt(args[1]);
	     //System.out.println(portNumber);
	     //Socket clientSocket = new Socket("127.0.0.1", 30121); 
	     Socket clientSocket = new Socket(hostName, portNumber);
<<<<<<< HEAD
	     System.out.println(clientSocket.getInetAddress());
=======


>>>>>>> branch 'master' of https://github.com/ayarmark/MCON243FinalProject.git
	     
	     ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
	     /**///ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
	     try {
			Job returnedJob = (Job)in.readObject();
			System.out.println(returnedJob.getJobType());
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
<<<<<<< HEAD
	clientSocket.close();
=======
	     

>>>>>>> branch 'master' of https://github.com/ayarmark/MCON243FinalProject.git
	}
}
