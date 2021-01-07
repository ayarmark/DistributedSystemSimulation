package client;

import java.io.*;
import java.net.*;
import java.util.Random;

import job.Job;
import job.JobType;


public class Client 
{
	public static void main(String [] args) throws UnknownHostException, IOException
	{
		//sends 30 jobs to master
		Client1ToMaster client1ToMaster = new Client1ToMaster();
		client1ToMaster.start();
		
		//receive from master
		Client1FromMaster client1FromMaster = new Client1FromMaster();
		client1FromMaster.start();
	}
}
