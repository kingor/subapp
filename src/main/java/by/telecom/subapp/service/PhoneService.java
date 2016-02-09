package by.telecom.subapp.service;

import java.util.List;

import by.telecom.subapp.model.Phone;
import by.telecom.subapp.model.Subscriber;
import by.telecom.subapp.model.User;

public interface PhoneService {
	public List getAll(Class<Phone> clazz, String sort, String orderType);
	//public List<User> getByLogin(String login);
	//public List<User> getByParameter(String login, String name, Integer category, String sort, String orderType);
}
