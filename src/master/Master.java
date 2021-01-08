package master;

public class Master 
{
	public static SharedMemory sharedMemory = new SharedMemory();
	public static void main(String[] args)
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
