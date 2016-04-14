package subapp;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import by.telecom.subapp.dao.SubscriberDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/WEB-INF/applicationContext.xml" })
public class DemoSpringTestCase extends TestCase {

	@Autowired
	SubscriberDao subscriberDao;

	@Test
	public void testInjectBlogDao() throws Exception {
		System.out.println("SubscriberDao = " + subscriberDao);
		assertNotNull(subscriberDao);
	}

}
