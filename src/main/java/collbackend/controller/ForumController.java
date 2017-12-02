package collbackend.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import collbackend.DAO.ForumDAO;
import collbackend.model.Forum;
@RestController
public class ForumController {
	@Autowired
	ForumDAO forumDAO;
	@GetMapping (value="/insertForum")
	public ResponseEntity<String> insertForum(@RequestBody Forum forum){
		if(forumDAO.addForum(forum))
		{
			return new ResponseEntity<String>("Forum Added",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Error in ResponseEntity",HttpStatus.SERVICE_UNAVAILABLE);
		}
	}
	@PostMapping(value="/updateForum")
	public ResponseEntity<String> updateForum(@RequestBody Forum forum){
		Forum tempForum=forumDAO.getForum(forum.getForumId());
		tempForum.setForumName(forum.getForumName());
		tempForum.setForumContent(forum.getForumContent());
		if(forumDAO.updateForum(forum))
		{
			return new ResponseEntity<String>("Forum Updated",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Error in Updation",HttpStatus.SERVICE_UNAVAILABLE);
		}
	}
	@GetMapping(value="/getAllForums")
	public ResponseEntity<ArrayList<Forum>>getAllForums(){
		ArrayList listForums=(ArrayList)forumDAO.getAllForums();
		return new ResponseEntity<ArrayList<Forum>>(listForums,HttpStatus.OK);
	}
	@PostMapping(value="/deleteForum")
	public ResponseEntity<String> deleteForum(@RequestBody Forum forum)
	{
		/*Forum forum=userDAO.getForum(forum.getForumId());*/
		if(forumDAO.deleteForum(forum)){
			return new ResponseEntity<String>("Forum deleted",HttpStatus.OK);
		}
		else{
			return new ResponseEntity<String>("Error in deletion",HttpStatus.SERVICE_UNAVAILABLE);
		}
	}
	}
