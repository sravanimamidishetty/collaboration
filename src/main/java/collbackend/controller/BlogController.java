package collbackend.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import collbackend.DAO.BlogDAO;
import collbackend.model.Blog;

@RestController
public class BlogController {
@Autowired
BlogDAO blogDAO;
@GetMapping (value="/insertBlog")
public ResponseEntity<String> insertBlog(@RequestBody Blog blog){
	if(blogDAO.addBlog(blog))
	{
		return new ResponseEntity<String>("Blog Added",HttpStatus.OK);
	}
	else
	{
		return new ResponseEntity<String>("Error in ResponseEntity",HttpStatus.SERVICE_UNAVAILABLE);
	}
}
@PostMapping(value="/updateBlog")
public ResponseEntity<String> updateBlog(@RequestBody Blog blog){
	Blog tempBlog=blogDAO.getBlog(blog.getBlogId());
	tempBlog.setBlogName(blog.getBlogName());
	tempBlog.setBlogContent(blog.getBlogContent());
	if(blogDAO.updateBlog(blog))
	{
		return new ResponseEntity<String>("Blog Updated",HttpStatus.OK);
	}
	else
	{
		return new ResponseEntity<String>("Error in Updation",HttpStatus.SERVICE_UNAVAILABLE);
	}
}
@GetMapping(value="/getAllBlogs")
public ResponseEntity<ArrayList<Blog>>getAllBlogs(){
	ArrayList listBlogs=(ArrayList)blogDAO.getAllBlogs();
	return new ResponseEntity<ArrayList<Blog>>(listBlogs,HttpStatus.OK);
}
@PostMapping(value="/deleteBlog")
public ResponseEntity<String> deleteBlog(@RequestBody Blog blog)
{
	/*Blog blog=blogDAO.getBlog(blog.getBlogId());*/
	if(blogDAO.deleteBlog(blog)){
		return new ResponseEntity<String>("Blog deleted",HttpStatus.OK);
	}
	else{
		return new ResponseEntity<String>("Error in deletion",HttpStatus.SERVICE_UNAVAILABLE);
	}
}
}