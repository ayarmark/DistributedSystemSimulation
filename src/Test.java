import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import writeAndRead.*;

public class Test 
{
	public static void main(String[] args)
	{
		ReadJob rj1 = new ReadJob( 30121);
		//rj1.start();
		rj1.run();

	}
}
