package collbackend.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import collbackend.model.User;
@Repository
public class UserDAOImpl implements UserDAO {
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	UserDAO userDAO;
	public UserDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	@Transactional
	public boolean addUser(User user) {
		try
		{
		sessionFactory.getCurrentSession().save(user);
		return true;
		}
		catch(Exception e)
		{
		System.out.println(e);
		return false;
		}	
	}
@Transactional
	public boolean updateUser(User user) {
		try
		{
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception occured:"+e);
		return false;
		}	
	}
@Transactional
	public boolean deleteUser(User user)
	{
		try
		{
		sessionFactory.getCurrentSession().delete(user);
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception occured:"+e);
		return false;
		}	
	}
@Transactional
	public User getUser(int userId) {
		Session session=sessionFactory.openSession();
		User user=(User)session.get(User.class, userId);
		session.close();
		return user;
	}
@Transactional
	public List<User> getAllusers() {
Session session=sessionFactory.openSession();
		
		List<User> userList=(List<User>)session.createQuery("from User").list();
		session.close();
		return userList;
	}
@Transactional
	public boolean approveUser(User user) {
		{
			try{
				user.setStatus("A");
				sessionFactory.getCurrentSession().saveOrUpdate(user);
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
	public boolean rejectUser(User user) {
		try{
			user.setStatus("N");
			sessionFactory.getCurrentSession().update(user);
			return true;
			}
			catch(Exception e)
			{
			System.out.println("Exception occured:"+e);
			return false;
			}	
		
	}	

}
