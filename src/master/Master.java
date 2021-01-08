package master;
public class Master 
{
	public static SharedMemory sharedMemory = new SharedMemory();
	public static void main(String[] args)
	{		
		MasterFromClient1 masterFromClient1 = new MasterFromClient1();
		MasterFromClient2 masterFromClient2 = new MasterFromClient2();
		MasterToSlaveA masterToSlaveA = new MasterToSlaveA();
		MasterToSlaveB masterToSlaveB = new MasterToSlaveB();
		MasterDecideSlave masterDecideSlave = new MasterDecideSlave();
		MasterFromSlaveA masterFromSlaveA = new MasterFromSlaveA();
		MasterFromSlaveB masterFromSlaveB = new MasterFromSlaveB();
		MasterToClient1 masterToClient1 = new MasterToClient1();
		MasterToClient2 masterToClient2 = new MasterToClient2();
		MasterDecideClient masterDecideClient = new MasterDecideClient();
		masterFromClient1.start();
		masterFromClient2.start();
		masterToSlaveA.start();
		masterToSlaveB.start();
		masterDecideSlave.start();
		masterFromSlaveA.start();
		masterFromSlaveB.start();
		masterToClient1.start();
		masterToClient2.start();
		masterDecideClient.start();
	}	
}
