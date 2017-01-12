package next.controller.user;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.ui.ExtendedModelMap;

import next.dao.UserDao;
import next.model.User;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {
	@Mock
	private UserDao userDao;
	
	@InjectMocks
	private UserController userController;

	@Test
	public void testProfile() throws Exception {
		when(userDao.findByUserId("test")).thenReturn(new User("test", "password", "name", ""));
		ExtendedModelMap model = new ExtendedModelMap();
		userController.profile("test", model);
		
		User user = (User)model.get("user");
		System.out.println("User: " + user);
	}
	
	@Test
	public void insert() throws Exception {
		User user = new User("test", "password", "name", "");
		userController.create(user);
		verify(userDao).insert(user);
	}

}
