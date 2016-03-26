package by.telecom.subapp.dao;

import java.util.List;

import by.telecom.subapp.model.Subscriber;

public interface SubscriberDao extends GenericDao<Subscriber, Long> {

	List<Subscriber> getByParameter(String name, String address, String comment, String sort,
			String orderType);
}
