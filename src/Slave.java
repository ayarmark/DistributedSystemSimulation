import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import client.Job;

public class Slave {

	public static void main(String[] args) throws UnknownHostException, IOException {
		args = new String[] { "30121" };

		if (args.length != 1) {
			System.err.println("Usage: java EchoServer <port number>");
			System.exit(1);
		}

		int portNumber = Integer.parseInt(args[0]);

		ReadJob readJob = new ReadJob(portNumber);
		readJob.run();
		//comment
		// System.out.println(portNumber);
		// Socket clientSocket = new Socket("127.0.0.1", 30121);
		Socket socket = new Socket();
		System.out.println(socket.getInetAddress());

		ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
		try {
			Job returnedJob = (Job) in.readObject();
			System.out.println(returnedJob.getJobType());
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		socket.close();
	}
}
