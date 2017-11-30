package collbackend.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "JOB")
@Component
public class Job {
	@Id
	 @GeneratedValue
    @Column(name = "JOB_ID")
	private int JobId;
	private String JobProfile;
	private String JobDesc;
	private String Qualification;
	private String Status;
	private Date PostDate;
	public int getJobId() {
		return JobId;
	}
	public void setJobId(int jobId) {
		JobId = jobId;
	}
	public String getJobProfile() {
		return JobProfile;
	}
	public void setJobProfile(String jobProfile) {
		JobProfile = jobProfile;
	}
	public String getJobDesc() {
		return JobDesc;
	}
	public void setJobDesc(String jobDesc) {
		JobDesc = jobDesc;
	}
	public String getQualification() {
		return Qualification;
	}
	public void setQualification(String qualification) {
		Qualification = qualification;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public Date getPostDate() {
		return PostDate;
	}
	public void setPostDate(Date postDate) {
		PostDate = postDate;
	}
	
}
