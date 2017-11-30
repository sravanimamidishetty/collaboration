package collbackend.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import collbackend.DAO.ForumDAO;
import collbackend.config.Dbconfig;
import collbackend.model.Forum;

@ComponentScan("collbackend")
public class ForumTest {
static ForumDAO forumDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.register(Dbconfig.class);
		context.scan("collbackend");
		context.refresh();
		
		forumDAO=(ForumDAO)context.getBean("forumDAO");
	}
	//@Ignore
	@Test
	public void addForumTest()
	{
		Forum forum=new Forum();
		forum.setForumId(1);
		forum.setForumName("web");
		forum.setForumContent("web design");
		forum.setUserId(12);
		forum.setCreateDate(new java.util.Date());
		
		assertTrue("Problem in Inserting Forum",forumDAO.addForum(forum));
	
	}
	
	@Ignore
	@Test
	public void updateForum()
	{
Forum forum=new Forum();
		
		forum.setForumId(1);
		forum.setForumName("web");
		forum.setForumContent("designing");
		assertTrue("Problem in Inserting Forum",forumDAO.addForum(forum));
	}
	
	@Ignore
	@Test
	public void getForumTest(){
		Forum forum=(Forum)forumDAO.getForum(1);
		
		System.out.println("ForumName:" + forum.getForumName());
		System.out.println("ForumContent:" +forum.getForumContent());
		
		assertNotNull("forum not found", forum);
	}
	
	@Ignore
	@Test
	public void deleteForumTest(){
		Forum forum=(Forum)forumDAO.getForum(1);
		assertTrue("Problem in deletion",forumDAO.deleteForum(forum));
	}
	@Ignore
	@Test
	public void approveForumTest(){
		Forum forum=(Forum)forumDAO.getForum(1);
		assertTrue("Problem in approving",forumDAO.approveForum(forum));
	}
	@Ignore
	@Test
	public void getAllForumTest(){
		List<Forum> forumList=(List<Forum>)forumDAO.getAllForums();
		assertNotNull("Forum list not found ",forumList.get(0));
		for(Forum forum:forumList)
		{
			System.out.println("ForumID:"+forum.getForumId() + "ForumName:"+forum.getForumName());
		}
	}
		
	}
	