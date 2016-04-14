package subapp;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import by.telecom.subapp.model.Subscriber;

public class TestSubscriber {

	@Test
	public void testSubscriber() {

		String testString = "1";
		Long testId = 1L;
		Subscriber testSbs = new Subscriber();
		testSbs.setId(testId);
		testSbs.setName(testString);
		testSbs.setAddress(testString);
		testSbs.setComment(testString);
		assertEquals(testSbs.getId(), testId);
		assertEquals(testSbs.getName(), testString);
		assertEquals(testSbs.getAddress(), testString);
		assertEquals(testSbs.getComment(), testString);
	}

}
