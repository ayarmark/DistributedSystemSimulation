package client;
import java.io.IOException;
import java.net.*;
public class Client 
{
	public static void main(String [] args) throws UnknownHostException, IOException
	{
		Socket socket = new Socket("127.0.0.1",123);
	}
}
