package by.telecom.subapp.service;

import java.util.List;

import by.telecom.subapp.model.Subscriber;
import by.telecom.subapp.model.User;

public interface SubscriberService {
	//public List getAll();
	public List getAll(Class<Subscriber> clazz, String sort, String orderType);
	//public List<User> getByLogin(String login);
	//public List<User> getByParameter(String login, String name, Integer category, String sort, String orderType);
}
