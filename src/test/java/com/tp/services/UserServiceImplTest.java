package com.tp.services;

import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;

import com.tp.entities.Role;
import com.tp.entities.User;

@SpringBootTest
class UserServiceImplTest {
	private static final Logger l = LogManager.getLogger(UserServiceImplTest.class);


	@Autowired
	IUserService us;
	
	private static User testCaseUser = new User("Fedi", "Soltani", new Date(1997, 4, 07), Role.INGENIEUR);;

	@Test
	@Order(1)
	void isConnectingtoDb() {
		List<User> listUsers = us.retrieveAllUsers();
		

	}

	@Test
	@Order(2)
	void addUser() {
		User user = us.addUser(UserServiceImplTest.testCaseUser);
		
		UserServiceImplTest.testCaseUser.setId(user.getId());
	}
	
	@Test
	@Order(3)
	void retrieveUser() {
		l.info(UserServiceImplTest.testCaseUser);
		User user = us.retrieveUser(UserServiceImplTest.testCaseUser.getId());
		
	}

	@Test
	@Order(4)
	void modifyUser() {
		User user = us.retrieveUser(UserServiceImplTest.testCaseUser.getId());
		user.setRole(Role.ADMINISTRATEUR);
		UserServiceImplTest.testCaseUser = us.updateUser(user);
		
	}
	
	@Test
	@Order(5)
	void deleteUser() {
		us.deleteUser(UserServiceImplTest.testCaseUser.getId());
		User user = us.retrieveUser(10L);
		
	}

}
