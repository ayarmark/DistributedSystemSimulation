
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
import java.io.*;
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.net.UnknownHostException;
import java.net.*;

import client.Job;
import client.JobType;

public class ReadJob {
	//String hostNum;
	int socketNum;
	Job job;
	Job currJob;
	boolean hasNewJob = false;
	boolean prevJobSent = true;
	String[] args = new String[] { "30121" };
	int portNumber = Integer.parseInt(args[0]);

	public ReadJob(int socketNum) {
		//this.hostNum = hostNum;
		this.socketNum = socketNum;
	}

	public void run() {
		try {
			// look at how simple client accepts things
			/*
			 * BufferedReader responseReader= // stream to read text response from server
			 * new BufferedReader( new InputStreamReader(clientSocket.getInputStream()));
			 */
			// InputStream inStrm = new InputStream();
			ServerSocket serverSocket = new ServerSocket(Integer.parseInt(args[0]));
			// ServerSocket serverSocket = new ServerSocket(portNumber);
			Socket clientSocket = serverSocket.accept();
			//ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
			ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
			in.readObject();
			serverSocket.close();

		}

		catch (UnknownHostException e) {
			//System.err.println("Don't know about host " + hostNum);
			System.exit(1);
		} catch (IOException e) {
			//System.err.println("Couldn't get I/O for the connection to " + hostNum);
			System.exit(1);
		} catch (ClassNotFoundException e) {
			System.err.println("Class not found.");

		}

	}
}
