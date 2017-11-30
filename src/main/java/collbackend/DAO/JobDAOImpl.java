package collbackend.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import collbackend.model.Job;
@Repository
public class JobDAOImpl implements JobDAO {
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	JobDAO jobDAO;
	
	public JobDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	@Transactional
	public boolean addJob(Job job) {
		try
		{
		sessionFactory.getCurrentSession().save(job);
		return true;
		}
		catch(Exception e)
		{
		System.out.println(e);
		return false;
		}	
	}
@Transactional
	public boolean updateJob(Job job) {
		try
		{
		sessionFactory.getCurrentSession().saveOrUpdate(job);
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception occured:"+e);
		return false;
		}	
	}
@Transactional
	public boolean deleteJob(Job job) {
		try
		{
		sessionFactory.getCurrentSession().delete(job);
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception occured:"+e);
		return false;
		}	
	}
@Transactional
	public Job getJob(int jobId) {
		Session session=sessionFactory.openSession();
		Job job=(Job)session.get(Job.class, jobId);
		session.close();
		return job;
	}
@Transactional
	public List<Job> getAlljobs() {
Session session=sessionFactory.openSession();
		
		List<Job> jobList=(List<Job>)session.createQuery("from Job").list();
		session.close();
		return jobList;
	}
@Transactional
	public boolean approveJob(Job job) {
		try{
			job.setStatus("A");
			sessionFactory.getCurrentSession().saveOrUpdate(job);
			return true;
			}
			catch(Exception e)
			{
			System.out.println("Exception occured:"+e);
			return false;
			}	
		}
@Transactional
	public boolean rejectJob(Job job) {
		try{
			job.setStatus("N");
			sessionFactory.getCurrentSession().update(job);
			return true;
			}
			catch(Exception e)
			{
			System.out.println("Exception occured:"+e);
			return false;
			}	
		
	}

}
