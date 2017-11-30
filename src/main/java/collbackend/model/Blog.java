package collbackend.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Entity
@Table(name = "BLOG")
@Component
public class Blog {
	@Id
	 @GeneratedValue
     @Column(name = "BLOG_ID")
private int BlogId;
private String BlogContent;
private String BlogName;
private int UserId;
private Date CreateDate;
private int Likes;
private String Status;
public int getBlogId() {
	return BlogId;
}
public void setBlogId(int blogId) {
	BlogId = blogId;
}
public String getBlogContent() {
	return BlogContent;
}
public void setBlogContent(String blogContent) {
	BlogContent = blogContent;
}
public String getBlogName() {
	return BlogName;
}
public void setBlogName(String blogName) {
	BlogName = blogName;
}
public int getUserId() {
	return UserId;
}
public void setUserId(int userId) {
	UserId = userId;
}
public int getLikes() {
	return Likes;
}
public void setLikes(int likes) {
	Likes = likes;
}
public String getStatus() {
	return Status;
}
public void setStatus(String status) {
	Status = status;
}
public Date getCreateDate() {
	return CreateDate;
}
public void setCreateDate(Date createDate) {
	CreateDate = createDate;
}
}
