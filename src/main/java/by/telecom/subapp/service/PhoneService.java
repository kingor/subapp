package by.telecom.subapp.service;

import java.util.List;

import by.telecom.subapp.model.Phone;
import by.telecom.subapp.model.Subscriber;

public interface PhoneService extends GenericService<Phone> {

	public List<Phone> getBySubscriber(Subscriber subscriber);

	public List<Phone> getByParameter(String number, String band, String security, String scv, String adsl, String name, String sort, String orderType);

}
