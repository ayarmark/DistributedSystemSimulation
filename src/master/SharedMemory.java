package master;

import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import job.Job;

public class SharedMemory 
{
	private int numAJobsSlaveA;
	private int numBJobsSlaveA;
	private int numAJobsSlaveB;
	private int numBJobsSlaveB;
	public ConcurrentLinkedQueue<Job> jobsFromClients;
	public ConcurrentLinkedQueue<Job> jobsToSendSlaveA;
	public ConcurrentLinkedQueue<Job> jobsToSendSlaveB;
	
	public SharedMemory()
	{
		numAJobsSlaveA=0;
		numBJobsSlaveA=0;
		numAJobsSlaveB=0;
		numBJobsSlaveB=0;
		jobsFromClients = new ConcurrentLinkedQueue<Job>();
		jobsToSendSlaveA = new ConcurrentLinkedQueue<Job>();
		jobsToSendSlaveB = new ConcurrentLinkedQueue<Job>();
	}

	public int getNumAJobsSlaveA() 
	{
		return numAJobsSlaveA;
	}

	public void setNumAJobsSlaveA(int numAJobsSlaveA) {
		this.numAJobsSlaveA = numAJobsSlaveA;
	}

	public int getNumBJobsSlaveA() {
		return numBJobsSlaveA;
	}

	public void setNumBJobsSlaveA(int numBJobsSlaveA) {
		this.numBJobsSlaveA = numBJobsSlaveA;
	}

	public int getNumAJobsSlaveB() {
		return numAJobsSlaveB;
	}

	public void setNumAJobsSlaveB(int numAJobsSlaveB) {
		this.numAJobsSlaveB = numAJobsSlaveB;
	}

	public int getNumBJobsSlaveB() {
		return numBJobsSlaveB;
	}

	public void setNumBJobsSlaveB(int numBJobsSlaveB) {
		this.numBJobsSlaveB = numBJobsSlaveB;
	}
	
	
}

