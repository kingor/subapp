package by.telecom.subapp.service;

import java.util.List;

import by.telecom.subapp.model.Phone;
import by.telecom.subapp.model.Subscriber;
import by.telecom.subapp.model.User;

public interface PhoneService {
	public List getAll(Class<Phone> clazz, String sort, String orderType);
	public List getBySubscriber(Subscriber subscriber);
	public List getByParameter(String number, String band,
			String security, String scv, String adsl, String name, String sort,
			String orderType);
}
