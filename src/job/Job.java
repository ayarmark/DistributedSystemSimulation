package job;
import java.io.*;
public class Job implements Serializable, Comparable<Job>{

	private JobType jobType;
	private static Integer jobID;
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

	private void setFinished(boolean isFinished) {
		this.isFinished = isFinished;
	}

	public JobType getJobType() {//penina made this public
		return jobType;
	}

	public static Integer getJobID() {//penina made this public
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
