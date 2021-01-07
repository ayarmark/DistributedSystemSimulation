package slaveA;
//c
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import job.Job;

public class Memory 
{
	Socket clientSocket;
	static ObjectInputStream in;
	static ObjectOutputStream out;
	
	public  Memory()
	{
		try 
		{
			clientSocket = new Socket("127.0.0.1", 30154);
			in = new ObjectInputStream(clientSocket.getInputStream());
			out = new ObjectOutputStream(clientSocket.getOutputStream());	
		
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} 
	}
}
