package collbackend.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import collbackend.DAO.BlogDAO;
import collbackend.config.Dbconfig;
import collbackend.model.Blog;

@ComponentScan("collbackend")
public class BlogTest {
static BlogDAO blogDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.register(Dbconfig.class);
		context.scan("collbackend");
		context.refresh();
		
		blogDAO=(BlogDAO)context.getBean("blogDAO");
	}
	
	@Ignore
	@Test
	public void addBlogTest()
	{
		Blog blog=new Blog();
		
		blog.setBlogId(1003);
		blog.setBlogName("HTML");
		blog.setBlogContent("Designed for web pages");
		blog.setStatus("p");
		blog.setLikes(6);
		blog.setCreateDate(new java.util.Date());
		
		assertTrue("Problem in Inserting Blog",blogDAO.addBlog(blog));
	
	}
	
	@Ignore
	@Test
	public void updateBlog()
	{
Blog blog=new Blog();
		
		blog.setBlogId(1);
		blog.setBlogName("HTML");
		blog.setBlogContent(" web pages");
		blog.setStatus("p");
		blog.setLikes(6);
		blog.setCreateDate(new java.util.Date());
		
		assertTrue("Problem in Inserting Blog",blogDAO.addBlog(blog));
	}
	
	@Ignore
	@Test
	public void getBlogTest(){
		Blog blog=(Blog)blogDAO.getBlog(3);
		
		System.out.println("BlogName:" + blog.getBlogName());
		System.out.println("BlogContent:" +blog.getBlogContent());
		
		assertNotNull("blog not found", blog);
	}
	
	//@Ignore
	@Test
	public void deleteBlogTest(){
		Blog blog=(Blog)blogDAO.getBlog(1);
		assertTrue("Problem in deletion",blogDAO.deleteBlog(blog));
	}
	@Ignore
	@Test
	public void approveBlogTest(){
		Blog blog=(Blog)blogDAO.getBlog(2);
		assertTrue("Problem in approving",blogDAO.approveBlog(blog));
	}
	@Ignore
	@Test
	public void getAllBlogTest(){
		List<Blog> blogList=(List<Blog>)blogDAO.getAllBlogs();
		assertNotNull("Blog list not found ",blogList.get(0));
		for(Blog blog:blogList)
		{
			System.out.println("BlogID:"+blog.getBlogId() + "BlogName:"+blog.getBlogName());
		}
	}
		
	}
	