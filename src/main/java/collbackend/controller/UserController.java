package collbackend.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import collbackend.DAO.UserDAO;
import collbackend.model.User;

@RestController
public class UserController {
	@Autowired
	UserDAO userDAO;
	@GetMapping (value="/insertUser")
	public ResponseEntity<String> insertUser(@RequestBody User user){
		if(userDAO.addUser(user))
		{
			return new ResponseEntity<String>("User Added",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Error in ResponseEntity",HttpStatus.SERVICE_UNAVAILABLE);
		}
	}
	@PostMapping(value="/updateUser")
	public ResponseEntity<String> updateUser(@RequestBody User user){
		User tempUser=userDAO.getUser(user.getUserId());
		tempUser.setFirstName(user.getFirstName());
		tempUser.setStatus(user.getStatus());
		if(userDAO.updateUser(user))
		{
			return new ResponseEntity<String>("User Updated",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Error in Updation",HttpStatus.SERVICE_UNAVAILABLE);
		}
	}
	@GetMapping(value="/getAllUsers")
	public ResponseEntity<ArrayList<User>>getAllUsers(){
		ArrayList listUsers=(ArrayList)userDAO.getAllusers();
		return new ResponseEntity<ArrayList<User>>(listUsers,HttpStatus.OK);
	}
	@PostMapping(value="/deleteUser")
	public ResponseEntity<String> deleteUser(@RequestBody User user)
	{
		/*User user=userDAO.getUser(user.getUserId());*/
		if(userDAO.deleteUser(user)){
			return new ResponseEntity<String>("User deleted",HttpStatus.OK);
		}
		else{
			return new ResponseEntity<String>("Error in deletion",HttpStatus.SERVICE_UNAVAILABLE);
		}
	}
}
