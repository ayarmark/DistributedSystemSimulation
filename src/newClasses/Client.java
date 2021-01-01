package newClasses;

import java.io.*;
import java.net.*;
import java.util.Random;

import newClasses.Job;
import newClasses.JobType;
import newThreads.Client1FromMaster;
import newThreads.Client1ToMaster;


public class Client 
{
	public static void main(String [] args) throws UnknownHostException, IOException
	{
		//set ID? probably not like this
		int clientID = 10;
		
		//create jobs
		JobType jobType;
	    Random rand = new Random();
		for(int i=0; i<30; i++) {
    	 	if(rand.nextInt(2) == 1) {
    	 		jobType = JobType.A;
    	 	}
    	 	else {
    	 		jobType = JobType.B;
    	 	}
    		System.out.println("Created request for job type " + jobType);
    		Job job = new Job(jobType, clientID);
		}
		
		//send to master
		Client1ToMaster client1ToMaster = new Client1ToMaster();
		client1ToMaster.start();

		//receive from master - need to first wait
		Client1FromMaster client1FromMaster = new Client1FromMaster();
		client1FromMaster.start();
	}
}
