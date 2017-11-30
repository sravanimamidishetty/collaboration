package collbackend.DAO;

import java.util.List;

import collbackend.model.User;

public interface UserDAO {

public boolean addUser(User user);
	
	public boolean updateUser(User user);
	
	public boolean deleteUser(User user);
	
	public User getUser(int userId);
	
	public List<User> getAllusers();
	
	public boolean approveUser(User user);
	
	public boolean rejectUser(User user);
	
}
