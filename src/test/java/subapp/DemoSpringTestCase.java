package subapp;

import static org.junit.Assert.assertNotNull;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import by.telecom.subapp.dao.SubscriberDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "./applicationContext-test.xml" })
public class DemoSpringTestCase {

	@Autowired
	SubscriberDao subscriberDao;

	// @Autowired
	// PhoneDao phoneDao;
	// @Autowired
	// UserDao userDao;
	// @Autowired
	// LogDao logDao;
	//

	@Ignore
	@Test
	public void testInjectSubscriberDao() throws Exception {
		System.out.println("SubscriberDao = " + subscriberDao);
		assertNotNull(subscriberDao);
	}
	//
	// @Test
	// public void testInjectPhoneDao() throws Exception {
	// System.out.println("PhoneDao = " + phoneDao);
	// assertNotNull(phoneDao);
	// }
	//
	// @Test
	// public void testInjectUserDao() throws Exception {
	// System.out.println("UserDao = " + userDao);
	// assertNotNull(userDao);
	// }
	//
	// @Test
	// public void testInjectLogDao() throws Exception {
	// System.out.println("LogDao = " + logDao);
	// assertNotNull(logDao);
	// }

}
