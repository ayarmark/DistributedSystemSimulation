package job;
import java.io.*;
public class Job implements Serializable, Comparable<Job>{

	private JobType jobType;
	private Integer jobID;
	private static Integer lastJobID =0;
	private Integer clientID;
	private boolean isFinished;
	
	public Job(JobType jobType, Integer clientID) {
		this.jobType = jobType;
		jobID = lastJobID++;
		this.clientID = clientID;
	}

	private boolean isFinished() {
		return isFinished;
	}

	public void setFinished(boolean isFinished) {//aidel made this public
		this.isFinished = isFinished;
	}

	public JobType getJobType() {//penina made this public
		return jobType;
	}

	public Integer getJobID() {//penina made this public
		return jobID;
	}

	private Integer getClientID() {
		return clientID;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Job [jobType=");
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
