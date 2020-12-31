package writeAndRead;

import java.io.*;
import java.net.*;
import client.Job;
import client.JobType;

public class ReadJob //extends Thread
{
	int socketNum;
	Job job;
	Job currJob;
	boolean hasNewJob = false;
	boolean prevJobSent = true;
	String[] args = new String[] { "30121" };
	int portNumber = Integer.parseInt(args[0]);

	public ReadJob(int socketNum) 
	{
		this.socketNum = socketNum;
	}

	public void run() 
	{
		try 
		{
			ServerSocket serverSocket = new ServerSocket(4999);
			Socket clientSocket = serverSocket.accept();
			ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
			//while(true)
			//{
			Job readJob = (Job) in.readObject();
			System.out.println(job.getJobType());
			//Job readJob; 
			/*while((job = (Job) in.readObject()) !=null)
			{
				System.out.println(job.getJobType());
			}*/
			
			//}
			
			//serverSocket.close();
		}

		catch (UnknownHostException e) {
			e.printStackTrace();
			//System.err.println("Don't know about host " + hostNum);
			System.exit(1);
		} catch (IOException e) {
			e.printStackTrace();
			//System.err.println("Couldn't get I/O for the connection to " + hostNum);
			System.exit(1);
		} catch (ClassNotFoundException e) {
			System.err.println("Class not found.");

		}

	}
}
