package subapp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import by.telecom.subapp.dao.LogDao;
import by.telecom.subapp.dao.PhoneDao;
import by.telecom.subapp.dao.SubscriberDao;
import by.telecom.subapp.dao.UserDao;
import by.telecom.subapp.model.Subscriber;
import by.telecom.subapp.service.SubscriberService;

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
	public void testInjectSubscriberService() throws Exception {
		System.out.println("SubscriberService = " + subscriberService);
		assertNotNull(subscriberService);
	}

	@Test
	public void saveAndSelect() throws Exception {

		Subscriber subscriber = new Subscriber();
		subscriber.setName("Test Client");
		subscriber.setAddress("Test Address");
		subscriber.setComment("Test Comment");

		subscriberService.create(subscriber);

		Subscriber selectedSubscriber = subscriberService.read(subscriber.getId());
		assertEquals(subscriber, selectedSubscriber);
	}

}
