package by.telecom.subapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.telecom.subapp.dao.PhoneDao;
import by.telecom.subapp.dao.SubscriberDao;
import by.telecom.subapp.model.Phone;
import by.telecom.subapp.model.Subscriber;
import by.telecom.subapp.service.PhoneService;
import by.telecom.subapp.service.SubscriberService;

@Service
public class PhoneServiceImpl implements PhoneService {
	
	@Autowired
	private PhoneDao phoneDao;
	
	@Transactional
	public List getAll(Class<Phone> clazz, String sort, String orderType) {
		return phoneDao.getAll(Phone.class, sort, orderType);
	}
	
	@Transactional
	public List getBySubscriber(Subscriber subscriber) {
		return phoneDao.getBySubscriber(subscriber);
	}

	@Transactional
	public List getByParameter(String number, String band, String security,
			String scv, String adsl, String name, String sort, String orderType) {
		return phoneDao.getByParameter(number, band, security, scv, adsl, name, sort, orderType);
	}

	@Transactional
	public Long create(Phone newInstance) {		
		return phoneDao.create(newInstance);
	}

	@Transactional
	public Phone read(Class<Phone> classT, Long id) {
		return phoneDao.read(classT, id);
	}

	@Transactional
	public void update(Phone phone) {
		phoneDao.update(phone);		
	}

	@Transactional
	public void delete(Phone phone) {
		phoneDao.delete(phone);
	}

}
