package job;
import java.io.*;
public class Job implements Serializable, Comparable<Job>{

	private static final long serialVersionUID = 1L;
	private JobType jobType;
	private Integer jobID;
	private static Integer lastJobID =0;
	private int clientID;
	private boolean isFinished;
	
	public Job(JobType jobType, Integer clientID) {
		this.jobType = jobType;
		jobID = lastJobID++;
		this.clientID = clientID;
	}

	public boolean isFinished() {
		return isFinished;
	}

	public void setFinished(boolean isFinished) {
		this.isFinished = isFinished;
	}

	public JobType getJobType() {
		return jobType;
	}

	public Integer getJobID() {
		return jobID;
	}

	public Integer getClientID() {
		return clientID;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Job [ID=");
		builder.append(jobID);
		builder.append(", jobType=");
		builder.append(jobType);
		builder.append(", clientID=");
		builder.append(clientID);
		builder.append(", isFinished=");
		builder.append(isFinished);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int compareTo(Job o) {
		return jobID.compareTo(o.getJobID());
	}
		
}
