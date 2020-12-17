package client;
import java.io.*;
public class Job implements Serializable {

	private JobType jobType;
	private static Integer jobID = 0;
	private Integer clientID;
	private boolean isFinished;
	//comment
	//penina made this public and extended the comment
	public Job(JobType jobType, /*maybe dont pass jobID in Integer jobID,*/ Integer clientID) {
		this.jobType = jobType;
		Job.jobID = ++jobID;
		//this.jobID = ++jobID;
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

	private static Integer getJobID() {
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
		
}
