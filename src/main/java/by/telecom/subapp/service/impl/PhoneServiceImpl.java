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

}
