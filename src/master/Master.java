package master;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.*;
import java.util.ArrayList;

import job.Job;
import job.JobType;

public class Master 
{
	public static SharedMemory sharedMemory = new SharedMemory();
	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException
	{		
		MasterFromClient1 masterFromClient1 = new MasterFromClient1();
		MasterToSlaveA masterToSlaveA = new MasterToSlaveA();
		MasterDecideSlave masterDecideSlave = new MasterDecideSlave();
		MasterFromSlaveA masterFromSlaveA = new MasterFromSlaveA();
		MasterToClient1 masterToClient1 = new MasterToClient1();
		MasterDecideClient masterDecideClient = new MasterDecideClient();
		masterFromClient1.start();
		masterToSlaveA.start();
		masterDecideSlave.start();
		masterFromSlaveA.start();
		masterToClient1.start();
		masterDecideClient.start();
	}	
}
