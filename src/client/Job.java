package client;

import java.io.Serializable;

public class Job implements Serializable{

	private JobType jobType;
	private static Integer jobID = 0;
	private String clientID;
	private boolean isFinished;
	
	//penina made this public and extended the comment
	public Job(JobType jobType, String clientID) {
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

	private String getClientID() {
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
