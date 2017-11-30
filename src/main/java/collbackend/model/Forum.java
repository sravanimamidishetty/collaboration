package collbackend.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "FORUM")
@Component
public class Forum {
	@Id
	 @GeneratedValue
     @Column(name = "FORUM_ID")
private int ForumId;
private String ForumContent;
private String ForumName;
private int UserId;
private Date CreateDate;
private String Status;
public int getForumId() {
	return ForumId;
}
public void setForumId(int forumId) {
	ForumId = forumId;
}
public String getForumContent() {
	return ForumContent;
}
public void setForumContent(String forumContent) {
	ForumContent = forumContent;
}
public String getForumName() {
	return ForumName;
}
public void setForumName(String forumName) {
	ForumName = forumName;
}
public int getUserId() {
	return UserId;
}
public void setUserId(int userId) {
	UserId = userId;
}
public Date getCreateDate() {
	return CreateDate;
}
public void setCreateDate(Date createDate) {
	CreateDate = createDate;
}
public String getStatus() {
	return Status;
}
public void setStatus(String status) {
	Status = status;
}

}
