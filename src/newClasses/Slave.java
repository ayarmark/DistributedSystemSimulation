package newClasses;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import newClasses.Job;
import newThreads.SlaveAFromMaster;
import newThreads.SlaveAToMaster;

public class Slave {

	public static void main(String[] args) throws UnknownHostException, IOException {
		//receive job from master
		SlaveAFromMaster slaveAFromMaster = new SlaveAFromMaster();
		slaveAFromMaster.start();
		
		//puts it in line
		//performs job and marks complete
		
		//send complete job back to master
		SlaveAToMaster slaveAToMaster = new SlaveAToMaster();
		slaveAToMaster.start();
	}
}
