package master;

import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import job.Job;

public class SharedMemory 
{
	public int numAJobsSlaveA;
	public int numBJobsSlaveA;
	public int numAJobsSlaveB;
	public int numBJobsSlaveB;
	public ConcurrentLinkedQueue<Job> jobsFromClients;
	public ConcurrentLinkedQueue<Job> jobsToSendSlaveA;
	public ConcurrentLinkedQueue<Job> jobsToSendSlaveB;
	public ConcurrentLinkedQueue<Job> jobsFromSlaves;
	public ConcurrentLinkedQueue<Job> jobsToSendClient1;
	public ConcurrentLinkedQueue<Job> jobsToSendClient2;
	
	public SharedMemory()
	{
		numAJobsSlaveA=0;
		numBJobsSlaveA=0;
		numAJobsSlaveB=0;
		numBJobsSlaveB=0;
		jobsFromClients = new ConcurrentLinkedQueue<Job>();
		jobsToSendSlaveA = new ConcurrentLinkedQueue<Job>();
		jobsToSendSlaveB = new ConcurrentLinkedQueue<Job>();
		jobsFromSlaves = new ConcurrentLinkedQueue<Job>();
		jobsToSendClient1 = new ConcurrentLinkedQueue<Job>();
		jobsToSendClient2 = new ConcurrentLinkedQueue<Job>();
	}
}

