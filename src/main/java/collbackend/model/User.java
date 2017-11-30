package collbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Entity
@Table(name = "USERS")
@Component
public class User {
	
	@Id
	@GeneratedValue
    @Column(name = "USER_ID")
private int UserId;
private String FirstName;
private String LastName;
private String Password;
private String EmailId;
private String Role;
private String status;
private String isOnlime;
public int getUserId() {
	return UserId;
}
public void setUserId(int userId) {
	UserId = userId;
}
public String getFirstName() {
	return FirstName;
}
public void setFirstName(String firstName) {
	FirstName = firstName;
}
public String getLastName() {
	return LastName;
}
public void setLastName(String lastName) {
	LastName = lastName;
}
public String getPassword() {
	return Password;
}
public void setPassword(String password) {
	Password = password;
}
public String getEmailId() {
	return EmailId;
}
public void setEmailId(String emailId) {
	EmailId = emailId;
}
public String getRole() {
	return Role;
}
public void setRole(String role) {
	Role = role;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getIsOnlime() {
	return isOnlime;
}
public void setIsOnlime(String isOnlime) {
	this.isOnlime = isOnlime;
}

}
