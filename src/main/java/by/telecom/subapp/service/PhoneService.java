package by.telecom.subapp.service;

import java.util.List;

import by.telecom.subapp.model.Phone;
import by.telecom.subapp.model.Subscriber;

public interface PhoneService {
	public List<Phone> getAll(String sort, String orderType);

	public List<Phone> getBySubscriber(Subscriber subscriber);

	public List<Phone> getByParameter(String number, String band, String security, String scv,
			String adsl, String name, String sort, String orderType);

	Long create(Phone newInstance);

	Phone read(Long id);

	void update(Phone phone);

	void delete(Phone phone);
}
