package collbackend.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import collbackend.DAO.FriendDAO;
import collbackend.config.Dbconfig;
import collbackend.model.Friend;

@ComponentScan("collbackend")
public class FriendTest {
static FriendDAO friendDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.register(Dbconfig.class);
		context.scan("collbackend");
		context.refresh();
		
		friendDAO=(FriendDAO)context.getBean("friendDAO");
	}
	
	//@Ignore
	@Test
	public void addFriendTest()
	{
		Friend friend=new Friend();
		friend.setFriendId(1);
		friend.setStatus("Y");
		assertTrue("Problem in Inserting Friend",friendDAO.addFriend(friend));
	}
	@Ignore
	@Test
	public void updateFriend()
	{
		Friend friend=new Friend();
		friend.setFriendId(1);
		friend.setStatus("N");
		assertTrue("Problem in Inserting Friend",friendDAO.addFriend(friend));
	}
	
	@Ignore
	@Test
	public void getFriendTest(){
		Friend friend=(Friend)friendDAO.getFriend(1);
		
		System.out.println("FriendId:" + friend.getFriendId());
		System.out.println("Status:" +friend.getStatus());
		
		assertNotNull("friend not found", friend);
	}
	
	@Ignore
	@Test
	public void deleteFriendTest(){
		Friend friend=(Friend)friendDAO.getFriend(1);
		assertTrue("Problem in deletion",friendDAO.deleteFriend(friend));
	}
	@Ignore
	@Test
	public void approveFriendTest(){
		Friend friend=(Friend)friendDAO.getFriend(2);
		assertTrue("Problem in approving",friendDAO.approveFriend(friend));
	}
	@Ignore
	@Test
	public void getAllFriendTest(){
		List<Friend> friendList=(List<Friend>)friendDAO.getAllFriends();
		assertNotNull("Friend list not found ",friendList.get(0));
		for(Friend friend:friendList)
		{
			System.out.println("FreindID:"+friend.getFriendId() + "Status:"+friend.getStatus());
		}
	}
		
}
