package client2;

import java.io.IOException;

import job.Job;

public class Client2FromMaster extends Thread{
	
	public void run() {
		
		try {
			Job returnedJob;
			while((returnedJob = (Job) Client2.in.readObject()) != null) {
				System.out.println(returnedJob + " is complete.");
			}
		} catch (IOException e2) {
			e2.printStackTrace();
		} catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
	}
}
