package by.telecom.subapp.service;

import java.util.List;

import by.telecom.subapp.model.Subscriber;

public interface SubscriberService {

	Long create(Subscriber subscriber);

	Subscriber read(Long id);

	void update(Subscriber subscriber);

	void delete(Subscriber subscriber);

	List<Subscriber> getAll(String sort, String orderType);

	List<Subscriber> getByParameter(String name, String address, String comment, String sort,
			String orderType);
}
