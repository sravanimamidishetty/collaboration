package collbackend.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import collbackend.DAO.FriendDAO;
import collbackend.model.Friend;
@RestController
public class FriendController {
	@Autowired
	FriendDAO friendDAO;
	@GetMapping (value="/insertFriend")
	public ResponseEntity<String> insertFriend(@RequestBody Friend friend){
		if(friendDAO.addFriend(friend))
		{
			return new ResponseEntity<String>("Friend Added",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Error in ResponseEntity",HttpStatus.SERVICE_UNAVAILABLE);
		}
	}
	@PostMapping(value="/updateFriend")
	public ResponseEntity<String> updateFriend(@RequestBody Friend friend){
		Friend tempFriend=friendDAO.getFriend(friend.getFriendId());
		tempFriend.setStatus(friend.getStatus());
		if(friendDAO.updateFriend(friend))
		{
			return new ResponseEntity<String>("Friend Updated",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Error in Updation",HttpStatus.SERVICE_UNAVAILABLE);
		}
	}
	@GetMapping(value="/getAllFriends")
	public ResponseEntity<ArrayList<Friend>>getAllFriends(){
		ArrayList listFriends=(ArrayList)friendDAO.getAllFriends();
		return new ResponseEntity<ArrayList<Friend>>(listFriends,HttpStatus.OK);
	}
	@PostMapping(value="/deleteFriend")
	public ResponseEntity<String> deleteFriend(@RequestBody Friend friend)
	{
		/*Friend friend=friendDAO.getFriend(friend.getFriendId());*/
		if(friendDAO.deleteFriend(friend)){
			return new ResponseEntity<String>("Friend deleted",HttpStatus.OK);
		}
		else{
			return new ResponseEntity<String>("Error in deletion",HttpStatus.SERVICE_UNAVAILABLE);
		}
	}
}
