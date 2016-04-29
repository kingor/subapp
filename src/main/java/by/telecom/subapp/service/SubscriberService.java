package by.telecom.subapp.service;

import java.util.List;

import by.telecom.subapp.model.Subscriber;

public interface SubscriberService extends GenericService<Subscriber> {

	List<Subscriber> getByParameter(String name, String address, String comment, String sort, String orderType);

}
