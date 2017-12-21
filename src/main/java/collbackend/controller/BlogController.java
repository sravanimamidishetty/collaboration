package collbackend.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import collbackend.DAO.BlogDAO;
import collbackend.model.Blog;

@RestController
public class BlogController {

		@Autowired
		BlogDAO blogDAO;
		
		@PostMapping(value="/insertBlog")
		public ResponseEntity<String> insertBlog(@RequestBody Blog blog)
		{
			if(blogDAO.addBlog(blog))
			{
				return new ResponseEntity<String>("Blog added",HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<String>("Error in responseentity",HttpStatus.SERVICE_UNAVAILABLE);
			}
		}	
		@PostMapping(value="/updateBlog")
		public ResponseEntity<String> updateBlog(@RequestBody Blog blog)
		{
			Blog tempBlog=blogDAO.getBlog(blog.getBlogId());
			
			tempBlog.setBlogName(blog.getBlogName());
			tempBlog.setBlogContent(blog.getBlogContent());
			
			if(blogDAO.updateBlog(tempBlog))
			{
				return new ResponseEntity<String>("Blog updated",HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<String>("Error in responseentity",HttpStatus.SERVICE_UNAVAILABLE);
			}
		}
		@GetMapping(value="/getAllBlogs")
		public ResponseEntity<ArrayList<Blog>> getAllBlogs()
		{
			ArrayList listblogs= (ArrayList)blogDAO.getAllBlogs();
			
			return new ResponseEntity<ArrayList<Blog>>(listblogs,HttpStatus.OK);
		}
		@PostMapping(value="/deleteBlog")
		public ResponseEntity<String> deleteBlog(@RequestBody Blog blog)
		{
			Blog tempBlog=blogDAO.getBlog(blog.getBlogId());
			if(blogDAO.deleteBlog(tempBlog))
			{
				return new ResponseEntity<String>("Blog deleted successfully",HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<String>("Error in responseentity",HttpStatus.SERVICE_UNAVAILABLE);
			}
		}
		@GetMapping(value="/approveBlog/{blogId}")
		public ResponseEntity<String> approveBlog(@PathVariable("blogId") int blogId)
		{
			Blog tempblog=blogDAO.getBlog(blogId);
			if(blogDAO.approveBlog(tempblog))
			{
				return new ResponseEntity<String>("Blog Approved",HttpStatus.OK);
			}
			else{
				return new ResponseEntity<String>("Error in Blog Approval",HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		@GetMapping(value="/rejectBlog/{blogId}")
		public ResponseEntity<String> rejectBlog(@PathVariable("blogId") int blogId)
		{
			Blog tempblog=blogDAO.getBlog(blogId);
			if(blogDAO.rejectBlog(tempblog))
			{
				return new ResponseEntity<String>("Blog Rejected",HttpStatus.OK);
			}
			else{
				return new ResponseEntity<String>("Error in Blog Rejection",HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		@GetMapping(value="/incLike/{blogId}")
		public ResponseEntity<String> incrementLike(@PathVariable("blogId") int blogId)
		{
			Blog tempblog=blogDAO.getBlog(blogId);
			if(blogDAO.incrementLike(tempblog))
			{
				return new ResponseEntity<String>("Likes Incremented",HttpStatus.OK);
			}
			else{
				return new ResponseEntity<String>("Error in Likes Incrementation",HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	}