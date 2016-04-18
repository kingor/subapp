package subapp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import by.telecom.subapp.dao.LogDao;
import by.telecom.subapp.dao.PhoneDao;
import by.telecom.subapp.dao.SubscriberDao;
import by.telecom.subapp.dao.UserDao;
import by.telecom.subapp.model.Log;
import by.telecom.subapp.model.Phone;
import by.telecom.subapp.model.Subscriber;
import by.telecom.subapp.model.User;
import by.telecom.subapp.service.LogService;
import by.telecom.subapp.service.PhoneService;
import by.telecom.subapp.service.SubscriberService;
import by.telecom.subapp.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext_test.xml" })
public class TestDaoInject {

	@Autowired
	SubscriberDao subscriberDao;
	@Autowired
	PhoneDao phoneDao;
	@Autowired
	UserDao userDao;
	@Autowired
	LogDao logDao;

	@Autowired
	SubscriberService subscriberService;
	@Autowired
	UserService userService;
	@Autowired
	LogService logService;
	@Autowired
	PhoneService phoneService;

	@Test
	public void testInjectSubscriberDao() throws Exception {
		System.out.println("SubscriberDao = " + subscriberDao);
		assertNotNull(subscriberDao);
	}

	@Test
	public void testInjectPhoneDao() throws Exception {
		System.out.println("PhoneDao = " + phoneDao);
		assertNotNull(phoneDao);
	}

	@Test
	public void testInjectUserDao() throws Exception {
		System.out.println("UserDao = " + userDao);
		assertNotNull(userDao);
	}

	@Test
	public void testInjectLogDao() throws Exception {
		System.out.println("LogDao = " + logDao);
		assertNotNull(logDao);
	}

	@Test
	public void saveAndSelectSubscriber() throws Exception {

		Subscriber subscriber = new Subscriber();
		subscriber.setName("Test Subscriber");
		subscriber.setAddress("Test Address");
		subscriber.setComment("Test Comment");

		subscriberService.create(subscriber);

		Subscriber selectedSubscriber = subscriberService.read(subscriber.getId());
		assertEquals(subscriber, selectedSubscriber);
	}

	@Test
	public void saveAndSelectUser() throws Exception {

		User user = new User();
		user.setName("Test Client");
		user.setLogin("Test Login");
		user.setPassword("Test password");
		user.setCategory(1);

		userService.create(user);

		User selectedUser = userService.read(user.getId());
		assertEquals(user, selectedUser);
	}

	@Test
	public void saveAndSelectLog() throws Exception {

		Log log = new Log();
		log.setUser("test user");
		log.setDate(new Date());
		log.setType("test type");
		log.setComment("test comment");

		logService.create("test user", "test type", "test comment");

		List<Log> logList = logService.getAll();
		assertNotNull(logList);
	}

	@Test
	public void saveAndSelectPhone() throws Exception {
		Subscriber subscriber = new Subscriber();
		subscriber.setName("Test Subscriber");
		subscriber.setAddress("Test Address");
		subscriber.setComment("Test Comment");

		Phone phone = new Phone();
		phone.setNumber("123456");
		phone.setBand("123");
		phone.setSecurity("123");
		phone.setScv("123");
		phone.setAdsl("123");
		phone.setSubscriber(subscriber);

		subscriberService.create(subscriber);
		phoneService.create(phone);

		Phone selectedPhone = phoneService.read(phone.getId());
		assertEquals(phone, selectedPhone);
	}

	@Test
	public void testGetInvalidId() {
		Subscriber result = subscriberService.read(-567890L);

		assertNull(result);
	}

}
