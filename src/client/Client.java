package client;
import java.io.*;
import java.net.*;
public class Client 
{
	public static void main(String [] args) throws UnknownHostException, IOException
	{
		args = new String[] {"127.0.0.1", "30121"};
    	
        if (args.length != 2) {
            System.err.println(
                "Usage: java EchoClient <host name> <port number>");
            System.exit(1);
        }
        
		 String hostName = args[0];
	     int portNumber = Integer.parseInt(args[1]);
	     //System.out.println(portNumber);
	     Socket clientSocket = new Socket(hostName, portNumber);

	     
	     ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
	     ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
	     try {
			Job returnedJob = (Job)in.readObject();
			System.out.println(returnedJob.getJobType());
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
