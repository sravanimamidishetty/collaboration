package collbackend.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import collbackend.model.Blog;
@Repository
public class BlogDAOImpl implements BlogDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	BlogDAO blogDAO;
	
	public BlogDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	public boolean addBlog(Blog blog) {

		try
		{
		sessionFactory.getCurrentSession().save(blog);
		return true;
		}
		catch(Exception e)
		{
		System.out.println(e);
		return false;
		}	
	}
	@Transactional
	public boolean updateBlog(Blog blog) {
		try
		{
		sessionFactory.getCurrentSession().update(blog);
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception occured:"+e);
		return false;
		}	
	}

	@Transactional
	public boolean deleteBlog(Blog blog) {
		try
		{
		sessionFactory.getCurrentSession().delete(blog);
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception occured:"+e);
		return false;
		}	
	}
@Transactional
	public Blog getBlog(int blogId) {
		Session session=sessionFactory.openSession();
		Blog blog=(Blog)session.get(Blog.class, blogId);
		session.close();
		return blog;
	}

	@Transactional
	public List<Blog> getAllBlogs() {
		Session session=sessionFactory.openSession();
		
		List<Blog> blogList=(List<Blog>)session.createQuery("from Blog").list();
		session.close();
		return blogList;
		
	}

	@Transactional
	public boolean approveBlog(Blog blog) {
			try{
				blog.setStatus("A");
				sessionFactory.getCurrentSession().update(blog);
				return true;
				}
				catch(Exception e)
				{
				System.out.println("Exception occured:"+e);
				return false;
				}	
			}
	
@Transactional
	public boolean rejectBlog(Blog blog) {
		try{
			blog.setStatus("N");
			sessionFactory.getCurrentSession().update(blog);
			return true;
			}
			catch(Exception e)
			{
			System.out.println("Exception occured:"+e);
			return false;
			}	
	}	
@Transactional
public boolean incrementLike(Blog blog){
	try{
		blog.setLikes(blog.getLikes()+1);
		sessionFactory.getCurrentSession().update(blog);
		return true;
	}
	catch(Exception e)
	{
		System.out.println("Exception Occured:"+e);
	return false;
	}
}
}
