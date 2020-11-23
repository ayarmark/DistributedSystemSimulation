
public class DecideSlave {
	int aBusy = (SharedMemory.getAinA()*2)+(SharedMemory.getBinA()*10);
	int bBusy = (SharedMemory.getBinB()*2)+(SharedMemory.getAinB()*10);
	if(job.type.equals("A")) {
		if(aBusy + 8 <= bBusy){
			//send to a
		} 
		else{
			//send to b
		}
	}
	else if(job.type.equals("B")) {
		if(bBusy + 8 <= aBusy){
			//send to b
		} 
		else{
			//send to a
		}
	}
}
