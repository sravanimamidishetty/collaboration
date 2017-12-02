package collbackend.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import collbackend.model.Friend;
@Repository
public class FriendDAOImpl implements FriendDAO {
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	FriendDAO friendDAO;
	public FriendDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	@Transactional
	public boolean addFriend(Friend friend) {
		try
		{
		sessionFactory.getCurrentSession().save(friend);
		return true;
		}
		catch(Exception e)
		{
		System.out.println(e);
		return false;
		}	
	}
@Transactional
	public boolean updateFriend(Friend friend) {
		try
		{
		sessionFactory.getCurrentSession().saveOrUpdate(friend);
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception occured:"+e);
		return false;
		}	
	}
@Transactional
	public boolean deleteFriend(Friend friend) {
		try
		{
		sessionFactory.getCurrentSession().delete(friend);
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception occured:"+e);
		return false;
		}	
	}
@Transactional
	public Friend getFriend(int friendId) {
		Session session=sessionFactory.openSession();
		Friend friend=(Friend)session.get(Friend.class, friendId);
		session.close();
		return friend;
	}
@Transactional
	public List<Friend> getAllFriends() {
Session session=sessionFactory.openSession();
		
		List<Friend> friendList=(List<Friend>)session.createQuery("from Friend").list();
		session.close();
		return friendList;
	}
@Transactional
	public boolean approveFriend(Friend friend) {
		try{
			friend.setStatus("A");
			sessionFactory.getCurrentSession().saveOrUpdate(friend);
			return true;
			}
			catch(Exception e)
			{
			System.out.println("Exception occured:"+e);
			return false;
			}	
	}
@Transactional
	public boolean rejectFriend(Friend friend) {
		try{
			friend.setStatus("N");
			sessionFactory.getCurrentSession().update(friend);
			return true;
			}
			catch(Exception e)
			{
			System.out.println("Exception occured:"+e);
			return false;
			}	
		
	}	
	}