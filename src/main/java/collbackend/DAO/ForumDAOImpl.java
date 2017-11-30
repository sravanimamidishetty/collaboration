package collbackend.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import collbackend.model.Forum;
@Repository
public class ForumDAOImpl implements ForumDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	ForumDAO forumDAO;
	
	public ForumDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	public boolean addForum(Forum forum) {

		try
		{
		sessionFactory.getCurrentSession().save(forum);
		return true;
		}
		catch(Exception e)
		{
		System.out.println(e);
		return false;
		}	
	}
	@Transactional
	public boolean updateForum(Forum forum) {
		try
		{
		sessionFactory.getCurrentSession().saveOrUpdate(forum);
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception occured:"+e);
		return false;
		}	
	}

	@Transactional
	public boolean deleteForum(Forum forum) {
		try
		{
		sessionFactory.getCurrentSession().delete(forum);
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception occured:"+e);
		return false;
		}	
	}
@Transactional
	public Forum getForum(int forumId) {
		Session session=sessionFactory.openSession();
		Forum forum=(Forum)session.get(Forum.class, forumId);
		session.close();
		return forum;
	}

	@Transactional
	public List<Forum> getAllForums() {
		Session session=sessionFactory.openSession();
		
		List<Forum> forumList=(List<Forum>)session.createQuery("from Forum").list();
		session.close();
		return forumList;
		
	}

	@Transactional
	public boolean approveForum(Forum forum) {
		{
			try{
				forum.setStatus("A");
				sessionFactory.getCurrentSession().saveOrUpdate(forum);
				return true;
				}
				catch(Exception e)
				{
				System.out.println("Exception occured:"+e);
				return false;
				}	
			}
	}
@Transactional
	public boolean rejectForum(Forum forum) {
		try{
			forum.setStatus("N");
			sessionFactory.getCurrentSession().update(forum);
			return true;
			}
			catch(Exception e)
			{
			System.out.println("Exception occured:"+e);
			return false;
			}	
		
	}	

}
