package by.telecom.subapp.dao;

import java.util.List;

import by.telecom.subapp.model.Phone;
import by.telecom.subapp.model.Subscriber;

public interface PhoneDao extends GenericDao<Phone, Long> {

	List<Phone> getBySubscriber(Subscriber subscriber);

	List<Phone> getByParameter(String number, String band, String security, String scv,
			String adsl, String name, String sort, String orderType);
}
