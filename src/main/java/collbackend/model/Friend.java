package collbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "FRIENDS")
@Component
public class Friend {
	@Id
	 @GeneratedValue
    @Column(name = "FRIEND_ID")
	private int UserId;
	private int FriendId;
	private String Status;
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public int getFriendId() {
		return FriendId;
	}
	public void setFriendId(int friendId) {
		FriendId = friendId;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	
}
