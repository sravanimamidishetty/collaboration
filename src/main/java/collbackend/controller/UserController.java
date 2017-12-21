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

import collbackend.DAO.UserDAO;
import collbackend.model.User;

@RestController
public class UserController {
	private static final int username = 0;
	@Autowired
	UserDAO userDAO;
	@GetMapping (value="/registerUser")
	public ResponseEntity<String> registerUser(@RequestBody User user){
		System.out.println("Registration");
		user.setIsOnlime("N");
		user.setRole("User");
		if(userDAO.addUser(user))
		{
			return new ResponseEntity<String>("Registered",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Error in Registration",HttpStatus.SERVICE_UNAVAILABLE);
		}
	}
	@PostMapping(value="/logout/{username}")
	public ResponseEntity<String> loggingOut(@PathVariable("username")String Username)
		User user=userDAO.getUser(username);
		/*tempUser.setFirstName(user.getFirstName());
		tempUser.setStatus(user.getStatus());*/
		if(userDAO.updateOnlineStatus("N",user))
		{
			return new ResponseEntity<String>("Successfully loggedout",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Error in loggedout",HttpStatus.SERVICE_UNAVAILABLE);
		}
	}
@PostMapping(value="/login")
public ResponseEntity<User> checkLogin(@RequestBody User user){
	if(userDAO.checkLogin(user))
	{
		User tempUser=userDAO.getUser(user.getUsername());
		tempUser.setIsOnlime("Y");
		session.getAttribute("username",user.getUsername());
		return new ResponseEntity<String>("tempUser",HttpStatus.OK);
	}
	else
	{
		return new ResponseEntity<String>("UserDetails",HttpStatus.SERVICE_UNAVAILABLE);
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
