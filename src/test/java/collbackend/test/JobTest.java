package collbackend.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import collbackend.DAO.JobDAO;
import collbackend.config.Dbconfig;
import collbackend.model.Blog;
import collbackend.model.Job;

@ComponentScan("collbackend")
public class JobTest {
static JobDAO jobDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.register(Dbconfig.class);
		context.scan("collbackend");
		context.refresh();
		
		jobDAO=(JobDAO)context.getBean("jobDAO");
	}
	//@Ignore
	@Test
	public void addJobTest()
	{
		Job job=new Job();
		job.setJobProfile("software");
		job.setJobDesc("software trainer");
		job.setQualification("btech");
		job.setStatus("Y");
		job.setPostDate(new java.util.Date());
		
		assertTrue("Problem in Inserting Job",jobDAO.addJob(job));
	
	}
	
	@Ignore
	@Test
	public void updateJob()
	{
		Job job=new Job();
		job.setJobProfile("software");
		job.setJobDesc("software engineer");
		job.setQualification("btech");
		job.setStatus("Y");
		job.setPostDate(new java.util.Date());
		
		assertTrue("Problem in Inserting Job",jobDAO.addJob(job));
	}
	
	@Ignore
	@Test
	public void getJobTest(){
		Job job=(Job)jobDAO.getJob(1);
		
		System.out.println("JobProfile:" + job.getJobProfile());
		System.out.println("Status:" +job.getStatus());
		
		assertNotNull("job not found", job);
	}
	
	@Ignore
	@Test
	public void deleteJobTest(){
		Job job=(Job)jobDAO.getJob(1);
		assertTrue("Problem in deletion",jobDAO.deleteJob(job));
	}
	@Ignore
	@Test
	public void approveJobTest(){
		Job job=(Job)jobDAO.getJob(2);
		assertTrue("Problem in approving",jobDAO.approveJob(job));
	}
	@Ignore
	@Test
	public void getAllJobTest(){
		List<Job> jobList=(List<Job>)jobDAO.getAlljobs();
		assertNotNull("Job list not found ",jobList.get(0));
		for(Job job:jobList)
		{
			System.out.println("JObID:"+job.getJobId() + "JobProfile:"+job.getJobProfile());
		}
	}
		
	}
	
