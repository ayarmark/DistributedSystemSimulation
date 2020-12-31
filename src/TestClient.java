import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import client.*;


public class TestClient 
{
	public static void main(String[] args)
	{
		try 
		{
			Socket clientWriteSocket = new Socket( "127.0.0.1",4999);
			ObjectOutputStream out = new ObjectOutputStream(clientWriteSocket.getOutputStream());
			Job job = new Job(JobType.A, 3);
			out.writeObject(job);
		} 
		catch (UnknownHostException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
